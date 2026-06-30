package br.com.trabalhopoo.mybar.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

<<<<<<< HEAD
import br.com.trabalhopoo.mybar.model.Cliente;
import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.model.Pagamento;
import br.com.trabalhopoo.mybar.model.enums.Sexo;
import br.com.trabalhopoo.mybar.repository.ClienteRepository;
=======
import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.model.Pagamento;
import br.com.trabalhopoo.mybar.model.enums.Sexo;
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
import br.com.trabalhopoo.mybar.repository.ConfiguracaoRepository;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.model.enums.Status;
<<<<<<< HEAD
import br.com.trabalhopoo.mybar.dto.ContaDto;
import br.com.trabalhopoo.mybar.dto.PagamentoDto;
import br.com.trabalhopoo.mybar.model.enums.FormaDePagamento;
import br.com.trabalhopoo.mybar.exception.ContaComNumeroJaExistenteException;
=======
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
import br.com.trabalhopoo.mybar.exception.ContaComPedidosException;
import br.com.trabalhopoo.mybar.exception.ContaFaltandoPagamentoException;
import br.com.trabalhopoo.mybar.exception.ContaJaAbertaException;
import br.com.trabalhopoo.mybar.exception.ContaJaFechadaException;
import br.com.trabalhopoo.mybar.exception.ContaNaoEncontradaException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;


@Service
public class ContaService {
    private ContaRepository contaRepository;
    private ConfiguracaoService configuracaoService;
<<<<<<< HEAD
    private ItemDaContaService itemDaContaService;
    private ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ConfiguracaoService configuracaoService,ClienteRepository clienteRepository,@Lazy ItemDaContaService itemDaContaService) {
        this.contaRepository = contaRepository;
        this.configuracaoService = configuracaoService;
        this.clienteRepository = clienteRepository;
        this.itemDaContaService = itemDaContaService;
=======

    public ContaService(ContaRepository contaRepository, ConfiguracaoService configuracaoService) {
        this.contaRepository = contaRepository;
        this.configuracaoService = configuracaoService;
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
    }

    public List<Conta> listarContas()
    {
        return contaRepository.findAll();
    }

    public Conta abrirConta(ContaDto dto)
    {
        Cliente cliente = clienteRepository.findById(dto.getCpfCliente())
            .orElseGet(() -> {
                Cliente novo = new Cliente();
                novo.setCpf(dto.getCpfCliente());
                novo.setNome(dto.getNomeCliente());
                novo.setCelular(dto.getCelularCliente());
                novo.setSexo(dto.getSexoCliente());
                return novo;
            });
        Conta conta = new Conta();
        // 3. Conecta o Cliente na Conta
        conta.setCliente(cliente);
        conta.setNumero(dto.getNumeroConta());
        conta.setDataAbertura(LocalDate.now());
        conta.setHoraAbertura(LocalTime.now());
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

    public Conta alterarConta(Long id, ContaDto contaDto)
    {

        Conta conta = pesquisarConta(id);

        if (!conta.getItensDaConta().isEmpty()) {
            throw new ContaComPedidosException(
                    "Não é possível alterar uma conta que possui pedidos.");
        }

        boolean numeroEmUso =
                contaRepository.existsByNumero(contaDto.getNumeroConta());

        if (numeroEmUso &&
                !conta.getNumero().equals(contaDto.getNumeroConta())) {

            throw new ContaComNumeroJaExistenteException(
                    "Já existe uma conta utilizando este número.",id);
        }
        conta.setNumero(contaDto.getNumeroConta());
        conta.getCliente().setNome(contaDto.getNomeCliente());
        conta.getCliente().setSexo(contaDto.getSexoCliente());
        conta.getCliente().setCelular(contaDto.getCelularCliente());
        conta.setDataAbertura(contaDto.getData());
        conta.setHoraAbertura(contaDto.getHora());

        //conta.setGarconAbertura(novaConta.getGarconAbertura());

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
    public List<Conta> pesquisarContaPorFiltros(Integer numero, String cpf, String nome, Status status)
    {
        return contaRepository.buscarComFiltros(numero, cpf, nome, status);
    }
    public Conta pesquisarConta(Long id)
    {
        Conta encontrado = (Conta) contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException("Conta não foi encontrada"));
        return encontrado;

    }
    public BigDecimal calcularGorjeta(Long id)
    {
        Conta conta = pesquisarConta(id);
        BigDecimal gorjeta = BigDecimal.ZERO;

        for (ItemDaConta item : conta.getItensDaConta()) {
            if (item.getItemCardapio() == null) continue;

            BigDecimal percentualReal = item.getItemCardapio()
                    .getTipoItem()
                    .getGorjeta()
                    .divide(BigDecimal.valueOf(100));

            gorjeta = gorjeta.add(item.getValor().multiply(percentualReal));
        }
<<<<<<< HEAD
        /*if (gorjeta.compareTo(BigDecimal.ZERO) > 0) {
=======

        Configuracao config = configuracaoService.obterConfiguracao();
        BigDecimal valorIngresso = conta.getCliente().getSexo() == Sexo.MASCULINO
                ? config.getValorIngressoMasc()
                : config.getValorIngressoFemin();

        conta.adicionarItem(new ItemDaConta(valorIngresso));

        if (gorjeta.compareTo(BigDecimal.ZERO) > 0) {
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
            conta.adicionarItem(new ItemDaConta(gorjeta));
        }*/
        return gorjeta;

<<<<<<< HEAD
    }
    public BigDecimal calcularValorIngresso(Long id)
    {
        Conta conta = pesquisarConta(id);
        Configuracao config = configuracaoService.obterConfiguracao();
        BigDecimal valorIngresso = conta.getCliente().getSexo() == Sexo.MASCULINO
                ? config.getValorIngressoMasc()
                : config.getValorIngressoFemin();

        return valorIngresso;
    }
    public List<ItemDaConta> ListarItensFechamento(Long id)
    {
        return itemDaContaService.listarPorConta(id);
    }
    public BigDecimal CalcularTotalConta(Long id, BigDecimal valorIngresso, BigDecimal valorGorjeta)
    {
        Conta conta = pesquisarConta(id);
        BigDecimal totalConta = conta.getItensDaConta().stream()
                .map(ItemDaConta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        totalConta.add(valorGorjeta);
        totalConta.add(valorIngresso);
        return totalConta;

    }
    public BigDecimal CalcularTotalPago(Long id)
    {
        Conta conta = pesquisarConta(id);
        BigDecimal totalPago = conta.getPagamentos().stream()
                .map(Pagamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPago;


    }
    public Conta FecharConta(Long id,BigDecimal totalConta, BigDecimal totalPago,BigDecimal valorIngresso, BigDecimal valorGorjeta)
    {
        Conta conta = pesquisarConta(id);

        if (conta.getStatus() == Status.FECHADA) {
            throw new ContaJaFechadaException("A conta já está fechada.",id);
        }
=======
        BigDecimal totalConta = conta.getItensDaConta().stream()
                .map(ItemDaConta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPago = conta.getPagamentos().stream()
                .map(Pagamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a

        if (totalPago.compareTo(totalConta) != 0) {
            throw new ContaFaltandoPagamentoException("A soma dos pagamentos é diferente do valor total da conta.",id);
        }
        ItemDaConta itemIngresso = new ItemDaConta(valorIngresso);
        ItemDaConta itemGorjeta = new ItemDaConta(valorGorjeta);
        itemIngresso.setQuantidade(1);
        itemGorjeta.setQuantidade(1);
        conta.setStatus(Status.FECHADA);
        conta.adicionarItem(itemIngresso);
        if (valorGorjeta.compareTo(BigDecimal.ZERO) > 0) {
            conta.adicionarItem(itemGorjeta);
        }
        return contaRepository.save(conta);
       
    }
<<<<<<< HEAD
    public Pagamento AdicionarPagamento(Long id, PagamentoDto pagamentoDto)
    {
        Conta conta = pesquisarConta(id);
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(pagamentoDto.getValor());
        if (pagamentoDto.getForma() != null) {
        pagamento.setForma(FormaDePagamento.valueOf(pagamentoDto.getForma().toUpperCase()));
    }
        conta.adicionarPagamento(pagamento);
        contaRepository.save(conta);
        return pagamento;

    }
    public List<Pagamento> ListarPagamentos(Long id)
    {
        return pesquisarConta(id).getPagamentos();
    }
=======
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
}
