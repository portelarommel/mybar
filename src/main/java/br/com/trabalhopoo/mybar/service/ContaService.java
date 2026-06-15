package br.com.trabalhopoo.mybar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.model.Conta;


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
}
