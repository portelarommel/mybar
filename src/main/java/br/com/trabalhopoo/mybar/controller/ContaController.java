package br.com.trabalhopoo.mybar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            @RequestParam(required = false) Boolean aberta,
            Model model){
        Status status = Status.ABERTA;
        if(aberta != null)
        {   
            status = aberta? Status.ABERTA : Status.FECHADA;

        }
        List<Conta> encontrada = contaService.pesquisarContaPorFiltros(numeroConta, cpf, nomeCliente, status);
        model.addAttribute("contas",encontrada);
        return "conta/gestaoDeContas";
    }

    @GetMapping("/{id}/editar")
    public String carregarPaginaEdicao(@PathVariable Long id, Model model)
    {
        Conta conta = contaService.pesquisarConta(id);
        model.addAttribute("conta",conta);
        return "conta/edicaoDeConta";
    }
    @PutMapping("/{id}/editar")
    public String alterarConta(@PathVariable Long id, @ModelAttribute Conta conta, Model model)
    {
        contaService.alterarConta(id, conta);
        return "redirect:/contas";
    }
    @GetMapping("/registrar")
    public String carregarPaginaRegistro(Model model)
    {
        model.addAttribute("conta", new Conta());
        return "conta/registroDeContas";
    } 
    @PostMapping("/registrar")
    public String abrirConta(@ModelAttribute Conta conta)
    {
        contaService.abrirConta(conta);
        return "redirect:/contas";
    }

    @DeleteMapping("/{id}/excluir")
    public String excluirConta(@PathVariable Long id)
    {
        contaService.excluirConta(id);
        return "redirect:/contas";
    }
}
