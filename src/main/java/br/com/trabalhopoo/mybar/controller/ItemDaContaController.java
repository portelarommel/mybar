package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ItemDaContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contas")
public class ItemDaContaController {

    private final ItemDaContaService itemDaContaService;

    public ItemDaContaController(ItemDaContaService itemDaContaService) {
        this.itemDaContaService = itemDaContaService;
    }

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
    }
}
