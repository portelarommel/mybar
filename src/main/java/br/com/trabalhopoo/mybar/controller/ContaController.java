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
import br.com.trabalhopoo.mybar.model.Usuario;
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
    public Conta buscarConta(@PathVariable Integer numero){
        return new Conta(); // código temporário
    }
    @PutMapping("/{numero}/editar")
    public ResponseEntity<Conta> editarConta(@PathVariable String numero, @RequestBody Conta conta)
    {
        return ResponseEntity.status(202).body(contaService.editarConta(conta));
    }
    @PostMapping("/registrar")
    public ResponseEntity<Conta> registrarConta(@RequestBody Conta conta)
    {
        return ResponseEntity.status(201).body(contaService.registrarConta(conta));
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
    public String registrarItemConta(@PathVariable Integer numero){
        return "";
    }
    @PutMapping("/{numero}/fechar")
    public String fecharConta(@PathVariable Integer numero)
    {
        return "";
    }




}
