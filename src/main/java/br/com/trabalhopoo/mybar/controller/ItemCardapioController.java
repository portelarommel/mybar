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

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.service.ItemCardapioService;
@Controller
@RequestMapping("/itensCardapio")
public class ItemCardapioController {
    @Autowired
    private final ItemCardapioService itemCardapioService;
    public ItemCardapioController(ItemCardapioService itemCardapioService)
    {
        this.itemCardapioService = itemCardapioService;
    }
    @GetMapping
    public ResponseEntity<List<ItemCardapio>> listarItensCardapio()
    {
        return ResponseEntity.status(200).body(itemCardapioService.listarItensCardapio());
    }

    @GetMapping("/buscarItem")
    public ResponseEntity<ItemCardapio> buscarItemCardapio(@RequestParam Integer codigo)
    {
        return ResponseEntity.status(200).body(itemCardapioService.buscarItemCardapio(codigo));

    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ItemCardapio> editarItemCardapio(@PathVariable Integer codigo, @RequestBody ItemCardapio itemCardapio)
    {
        return ResponseEntity.status(200).body(itemCardapioService.editarItemCardapio(itemCardapio));

    }
    @PostMapping("/registrar")
    public ResponseEntity<ItemCardapio> registrarItemCardapio(@RequestBody ItemCardapio itemCardapio)
    {
        return ResponseEntity.status(200).body(itemCardapioService.registrarItemCardapio(itemCardapio));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarItemCardapio(@PathVariable Integer codigo)
    {
        return ResponseEntity.status(201).body(itemCardapioService.deletarItemCardapio(codigo));

    }
     
    
    

}
