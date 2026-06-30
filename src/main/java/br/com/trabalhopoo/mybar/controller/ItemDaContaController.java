package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ItemDaContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ItemDaContaController {

    private final ItemDaContaService itemDaContaService;

    public ItemDaContaController(ItemDaContaService itemDaContaService) {
        this.itemDaContaService = itemDaContaService;
    }

    @PostMapping("/{id}/item")
    public ResponseEntity<ItemDaConta> registrarItemConta(@PathVariable Long id, @RequestBody ItemDaConta itemDaConta){
        return ResponseEntity.status(201).body(itemDaContaService.registrarItemConta(id, itemDaConta));
    }

    @GetMapping("/{id}/item")
    public ResponseEntity<List<ItemDaConta>> listarPorConta(@PathVariable Long id) {
        return ResponseEntity.ok(itemDaContaService.listarPorConta(id));
    }

    @DeleteMapping("/{id}/item/{itemId}")
    public ResponseEntity<?> excluirItem(@PathVariable Long id, @PathVariable Long itemId) {
        itemDaContaService.excluirItem(id, itemId);
        return ResponseEntity.noContent().build();
    }
}
