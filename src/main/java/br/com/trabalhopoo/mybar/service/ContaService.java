package br.com.trabalhopoo.mybar.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.trabalhopoo.mybar.model.Pagamento;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.enums.Status;
import br.com.trabalhopoo.mybar.exception.ContaComPedidosException;
import br.com.trabalhopoo.mybar.exception.ContaJaAbertaException;
import br.com.trabalhopoo.mybar.exception.ContaNaoEncontradaException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;


@Service
public class ContaService {
    private ContaRepository contaRepository;
    private ItemDaContaRepository itemDaContaRepository;

    public ContaService(ContaRepository contaRepository, ItemDaContaRepository itemDaContaRepository) {
        this.contaRepository = contaRepository;
        this.itemDaContaRepository = itemDaContaRepository;
    }

    public List<Conta> listarContas()
    {
        return contaRepository.findAll();
    }

    public Conta abrirConta(Conta conta)
    {
        String cpf = conta.getCliente().getCpf();

        if (contaRepository.existsByClienteCpfAndStatus(cpf, Status.ABERTA)) {
            throw new ContaJaAbertaException("Já existe uma conta aberta para este cliente.");
        }

        if (contaRepository.existsByNumero(conta.getNumero())) {
            throw new ContaJaAbertaException("Número de conta já utilizado.");
        }

        conta.setStatus(Status.ABERTA);

        return contaRepository.save(conta);
    }

    public Conta alterarConta(Long id, Conta novaConta)
    {

        Conta conta = pesquisarConta(id);

        if (!conta.getItensDaConta().isEmpty()) {
            throw new ContaComPedidosException(
                    "Não é possível alterar uma conta que possui pedidos.");
        }

        boolean numeroEmUso =
                contaRepository.existsByNumero(novaConta.getNumero());

        if (numeroEmUso &&
                !conta.getNumero().equals(novaConta.getNumero())) {

            throw new ContaJaAbertaException(
                    "Já existe uma conta utilizando este número.");
        }

        conta.setNumero(novaConta.getNumero());
        conta.setCliente(novaConta.getCliente());
        conta.setGarconAbertura(novaConta.getGarconAbertura());

        return contaRepository.save(conta);
    }

    public void excluirConta(Long id)
    {
        Conta conta = pesquisarConta(id);

        if (!conta.getItensDaConta().isEmpty()) {
            throw new ContaComPedidosException(
                    "Não é possível excluir uma conta que possui pedidos.");
        }

        contaRepository.delete(conta);
    }

    public Conta pesquisarConta(Long id)
    {
        Conta encontrado = (Conta) contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada"));
        return encontrado;

    }

    public Conta fecharConta(Long id)
    {

        Conta conta = pesquisarConta(id);

        if (conta.getStatus() == Status.FECHADA) {
            throw new IllegalStateException("A conta já está fechada.");
        }

        BigDecimal gorjeta = BigDecimal.ZERO;

        for (ItemDaConta item : conta.getItensDaConta()) {

            BigDecimal percentual =
                    item.getItemCardapio()
                            .getTipoItem()
                            .getGorjeta();

            gorjeta = gorjeta.add(
                    item.getValor().multiply(percentual));
        }

        if (gorjeta.compareTo(BigDecimal.ZERO) > 0) {
            conta.adicionarItem(new ItemDaConta(gorjeta));
        }

        BigDecimal totalConta = BigDecimal.ZERO;

        for (ItemDaConta item : conta.getItensDaConta()) {
            totalConta = totalConta.add(item.getValor());
        }

        BigDecimal totalPago = BigDecimal.ZERO;

        for (Pagamento pagamento : conta.getPagamentos()) {
            totalPago = totalPago.add(pagamento.getValor());
        }

        if (totalPago.compareTo(totalConta) != 0) {
            throw new IllegalStateException(
                    "A soma dos pagamentos é diferente do valor total da conta.");
        }

        conta.setStatus(Status.FECHADA);

        return contaRepository.save(conta);
    }

    public void registrarItemConta(Long id, ItemDaConta itemDaConta) {
        Conta conta = pesquisarConta(id);
        conta.adicionarItem(itemDaConta);
        contaRepository.save(conta);
    }
}
