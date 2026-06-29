package br.com.trabalhopoo.mybar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ContaService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    /*@GetMapping
    public ResponseEntity<List<Conta>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
    }*/

    @GetMapping
    public String pesquisarConta(@RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nomeCliente,
            @RequestParam(required = false) Boolean aberta){
        Status status = Status.ABERTA;
        if(aberta != null)
        {   
            status = aberta? Status.ABERTA : Status.FECHADA;

        }
        List<Conta> encontrada = contaService.pesquisarContaPorFiltros(numeroConta, cpf, nomeCliente, status);
        return "conta/gestaoDeContas";
    }

    @PutMapping("/{id}")
    public String alterarConta(@PathVariable Long id, @RequestBody Conta conta)
    {
        Conta editada = contaService.alterarConta(id, conta);
        return "conta/edicaoDeConta";
    }

    @PostMapping("/registrar")
    public String abrirConta(@RequestBody Conta conta)
    {
        return "conta/registroDeConta";
    }

    @DeleteMapping("/{id}/excluir")
    public String excluirConta(@PathVariable Long id)
    {
        contaService.excluirConta(id);
        return "redirect:/contas";
    }

    @PutMapping("/{id}/fechar")
    public String fecharConta(@PathVariable Long id)
    {
        Conta fechada = contaService.fecharConta(id);
        return "conta/fechamentoDeConta";
    }
}
