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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping
    public String listar(Model model){
        model.addAttribute("contas",contaService.listarContas());
        return "conta/listarConta";
    }
    @GetMapping("/buscar")
    public String buscarConta(@RequestParam String numero,Model model){
        Conta encontrada = contaService.buscarConta(numero);
        model.addAttribute(encontrada);
        return "conta/buscarConta";
    }
    @PutMapping("/{numeroAtual}/editar")
    public  String editarConta(@PathVariable String numeroAtual, @ModelAttribute Conta conta,RedirectAttributes attributes)
    {
        contaService.editarConta(numeroAtual,conta);
        attributes.addFlashAttribute("mensagem", "Conta editada com sucesso!");
        return "redirect:/contas";
    }
    @PostMapping("/registrar")
    public String registrarConta(@RequestBody Conta conta,RedirectAttributes attributes)
    {
        contaService.registrarConta(conta);
        attributes.addFlashAttribute("mensagem", "Conta registrada com sucesso!");

        return "redirect:/contas";
    }
    @DeleteMapping("/{numero}/deletar")
    public String deletarConta(@PathVariable String numero,RedirectAttributes attributes)
    {
        contaService.deletarConta(numero);
        attributes.addFlashAttribute("mensagem", "Conta apagada com sucesso!");
        return "redirect:/contas";
    }
    @PutMapping("/{numero}/registrarItem")
    public ResponseEntity<Conta> registrarItemConta(@PathVariable String numero, @ModelAttribute ItemDaConta itemDaConta, RedirectAttributes attributes){
        Conta nova  = contaService.registrarItemConta(numero, itemDaConta);
        attributes.addFlashAttribute("mensagem","Item adicionado na conta com sucesso!");
        return ResponseEntity.status(201).body(nova);
    }
    @PutMapping("/{numero}/fechar")
    public ResponseEntity<Conta> fecharConta(@PathVariable String numero)
    {
        Conta fechada = contaService.fecharConta(numero);
        return ResponseEntity.status(201).body(fechada);
    }




}
