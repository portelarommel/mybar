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

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ContaService;

@Controller
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private final ContaService contaService;
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }
    @GetMapping
    public String TabelaContas()
    {
        return "";
    }
    @GetMapping
    public ResponseEntity<List<Conta>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
    }
    @GetMapping
    public ResponseEntity<Conta> buscarConta(@PathVariable Integer numero){
        Conta encontrada = contaService.buscarConta(numero);
        return ResponseEntity.status(200).body(encontrada);
    }
    @PutMapping("/{numero}/editar")
    public ResponseEntity<Conta> editarConta(@PathVariable String numero, @RequestBody Conta conta)
    {
        return ResponseEntity.status(200).body(contaService.editarConta(conta));
    }
    @PostMapping("/registrar")
    public ResponseEntity<Conta> registrarConta(@RequestBody Conta conta)
    {
        Conta salva = contaService.registrarConta(conta);
        return ResponseEntity.status(201).body(salva);
    }
    @DeleteMapping("/{numero}/deletar")
    public ResponseEntity<?> deletarConta(@PathVariable Integer numero)
    {
        contaService.deletarConta(numero);
        return ResponseEntity.status(204).build();
    }
    @GetMapping("/{numero}/visualizar")
    public String visualizarConta(@PathVariable Integer numero)
    {
        return "";
    }
    @PutMapping("/{numero}/registrarItem")
    public ResponseEntity<Conta> registrarItemConta(@PathVariable Integer numero, @RequestBody ItemDaConta itemDaConta ){
        Conta nova  = contaService.registrarItemConta(numero, itemDaConta);
        return ResponseEntity.status(201).body(nova);
    }
    @PutMapping("/{numero}/fechar")
    public ResponseEntity<Conta> fecharConta(@PathVariable Integer numero)
    {
        Conta fechada = contaService.fecharConta(numero);
        return ResponseEntity.status(201).body(fechada);
    }




}
