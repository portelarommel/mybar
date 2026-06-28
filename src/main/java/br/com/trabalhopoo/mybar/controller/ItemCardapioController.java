package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.service.ItemCardapioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.service.ItemCardapioService;
@RestController
@RequestMapping("/itens-cardapio")
public class ItemCardapioController {

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

    @GetMapping("/pesquisar")
    public ResponseEntity<List<ItemCardapio>> pesquisarItemCardapio(@RequestParam(required = false) Long codigo,
        @RequestParam(required = false) String descricao,
        @RequestParam(required = false) Long tipoItemId)
    {
        return ResponseEntity.status(200).body(itemCardapioService.buscarItemCardapioPorFiltros(codigo,descricao,tipoItemId));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapio> editarItemCardapio(@PathVariable Long id, @RequestBody ItemCardapio itemCardapio)
    {
        itemCardapio.setId(id);
        return ResponseEntity.status(200).body(itemCardapioService.editarItemCardapio(itemCardapio));
    }

    @PostMapping
    public ResponseEntity<ItemCardapio> registrarItemCardapio(@RequestBody ItemCardapio itemCardapio)
    {
        return ResponseEntity.status(200).body(itemCardapioService.registrarItemCardapio(itemCardapio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarItemCardapio(@PathVariable Long id)
    {
        itemCardapioService.deletarItemCardapio(id);
        return ResponseEntity.status(201).build();
    }
}
