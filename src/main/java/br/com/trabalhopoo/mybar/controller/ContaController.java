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
    @GetMapping("/buscarConta")
    public ResponseEntity<Conta> buscarConta(@RequestParam String numero){
        Conta encontrada = contaService.buscarConta(numero);
        return ResponseEntity.status(200).body(encontrada);
    }
    @PutMapping("/{numeroAtual}/editar")
    public ResponseEntity<Conta> editarConta(@PathVariable String numeroAtual, @RequestBody Conta conta)
    {
        Conta editada = contaService.editarConta(numeroAtual,conta);
        return ResponseEntity.status(200).body(editada);
    }
    @PostMapping("/registrar")
    public ResponseEntity<Conta> registrarConta(@RequestBody Conta conta)
    {
        Conta salva = contaService.registrarConta(conta);
        return ResponseEntity.status(201).body(salva);
    }
    @DeleteMapping("/{numero}/deletar")
    public ResponseEntity<?> deletarConta(@PathVariable String numero)
    {
        contaService.deletarConta(numero);
        return ResponseEntity.status(204).build();
    }
    @PutMapping("/{numero}/registrarItem")
    public ResponseEntity<Conta> registrarItemConta(@PathVariable String numero, @RequestBody ItemDaConta itemDaConta ){
        Conta nova  = contaService.registrarItemConta(numero, itemDaConta);
        return ResponseEntity.status(201).body(nova);
    }
    @PutMapping("/{numero}/fechar")
    public ResponseEntity<Conta> fecharConta(@PathVariable String numero)
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
