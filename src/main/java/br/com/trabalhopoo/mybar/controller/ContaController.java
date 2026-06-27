package br.com.trabalhopoo.mybar.controller;

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

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ContaService;
import org.springframework.ui.Model;

@RestController
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

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarConta(@PathVariable Long id){
        Conta encontrada = contaService.pesquisarConta(id);
        return ResponseEntity.status(200).body(encontrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> alterarConta(@PathVariable Long id, @RequestBody Conta conta)
    {
        Conta editada = contaService.alterarConta(id, conta);
        return ResponseEntity.status(200).body(editada);
    }

    @PostMapping()
    public ResponseEntity<Conta> abrirConta(@RequestBody Conta conta)
    {
        return ResponseEntity.status(201).body(contaService.abrirConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirConta(@PathVariable Long id)
    {
        contaService.excluirConta(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/{id}/fechar")
    public ResponseEntity<Conta> fecharConta(@PathVariable Long id)
    {
        Conta fechada = contaService.fecharConta(id);
        return ResponseEntity.status(201).body(fechada);
    }

    @PutMapping("/{id}/addItem")
    public ResponseEntity<?> registrarItemConta(@PathVariable Long id, @RequestBody ItemDaConta itemDaConta){
        contaService.registrarItemConta(id, itemDaConta);
        return ResponseEntity.status(201).build();
    }
}
