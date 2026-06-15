package br.com.trabalhopoo.mybar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.enums.Status;
import br.com.trabalhopoo.mybar.exception.ContaJaAbertaException;
import br.com.trabalhopoo.mybar.exception.ContaNaoEncontradaException;
import br.com.trabalhopoo.mybar.model.Conta;
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

}
