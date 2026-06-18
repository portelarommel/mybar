package br.com.trabalhopoo.mybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import br.com.trabalhopoo.mybar.enums.Status;
import br.com.trabalhopoo.mybar.exception.ContaJaAbertaException;
import br.com.trabalhopoo.mybar.exception.ContaNaoEncontradaException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.model.Usuario;


@Service
public class ContaService {
    private ContaRepository contaRepository;
    public ContaService(ContaRepository contaRepository)
    {
        this.contaRepository = contaRepository;
    }
    public List<Conta> listarContas()
    {
        return contaRepository.findAll();
    }
    public Conta registrarConta(Conta conta)
    {
        String cpf = conta.getCliente().getCpf();

        if(contaRepository.existsByClienteCpfAndStatus(cpf,Status.ABERTA))
        {
            throw new ContaJaAbertaException("Já existe conta aberta com esse CPF!");
        }


        Conta nova =  contaRepository.save(conta);
        return nova;
    }
    public Conta editarConta(Conta conta)
    {
        Conta contaEditada =  contaRepository.save(conta);
        return contaEditada;
    }
    public Boolean deletarConta(Integer numero)
    {
        contaRepository.deleteById(numero);
        return true;

    }
    public Conta buscarConta(Integer numero)
    {

        Conta encontrado = (Conta)contaRepository.findById(numero).orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada"));
        return encontrado;

    }
    public Conta registrarItemConta(Integer numero, ItemDaConta itemDaConta )
    {
        Conta conta = buscarConta(numero);
        conta.adicionarItem(itemDaConta);
        contaRepository.save(conta);
        return conta;

    }
    public Conta fecharConta(Integer numero)
    {
        Conta conta = buscarConta(numero);
        BigDecimal total = new BigDecimal(0);
        for (ItemDaConta item : conta.getItensDaConta())
        {
            BigDecimal aux = item.getValor().multiply( item.getItemCardapio().getTipoDeItem().getGorjeta());
            total = total.add(aux);
        }
        ItemDaConta gorjeta = new ItemDaConta(total);
        conta.adicionarItem(gorjeta);
        return conta;
      
    }

}
