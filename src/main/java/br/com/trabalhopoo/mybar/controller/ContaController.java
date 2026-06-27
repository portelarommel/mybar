package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private final ContaService contaService;
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
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
