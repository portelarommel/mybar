package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ItemDaContaService;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@Controller
=======
@RestController
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
@RequestMapping("/contas")
public class ItemDaContaController {

    private final ItemDaContaService itemDaContaService;

    public ItemDaContaController(ItemDaContaService itemDaContaService) {
        this.itemDaContaService = itemDaContaService;
    }

<<<<<<< HEAD
    @PostMapping("/{id}/registrar")
    public String registrarItemConta(@PathVariable Long id, @ModelAttribute ItemDaConta itemDaConta){
        return "redirect:/contas/"+id+"/itens";
    }

    @GetMapping("/{id}/itens")
    public String listarPorConta(@PathVariable Long id, Model model) {

        model.addAttribute("itens", itemDaContaService.listarPorConta(id));
        return "conta/registroDeItemConta" ;
    }

    @DeleteMapping("/{id}/item/{itemId}")
    public String excluirItem(@PathVariable Long id, @PathVariable Long itemId) {
        itemDaContaService.excluirItem(id, itemId);
        return "redirect:/contas/"+id+"/itens";
=======
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
>>>>>>> 71442c31b25ab4adee3ea5aa12397f4004a53d2a
    }
}
