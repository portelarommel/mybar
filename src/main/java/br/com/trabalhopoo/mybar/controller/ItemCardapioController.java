package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.service.ItemCardapioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensCardapio")
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

    @GetMapping("/{id}")
    public ResponseEntity<ItemCardapio> buscarItemCardapio(@PathVariable long id)
    {
        return ResponseEntity.status(200).body(itemCardapioService.buscarItemCardapio(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapio> editarItemCardapio(@PathVariable Long id, @RequestBody ItemCardapio itemCardapio)
    {
        itemCardapio.setId(id);
        return ResponseEntity.status(200).body(itemCardapioService.editarItemCardapio(itemCardapio));
    }

    @PostMapping()
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
