package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ControleEntregaService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/controle-entrega")
public class ControleEntregaController {
    @Autowired
    private ControleEntregaService controleEntregaService;

    @GetMapping
    public String buscarControleEntrega(
            @RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) String nomeCliente,
            Model model) {
            
        List<ItemDaConta> resultado = controleEntregaService.buscarItemDaConta(numeroConta, nomeCliente);
        model.addAttribute("itens", resultado);
        return "gestaoDeControleDeEntrega";
    }
    @Transactional
    @PostMapping
    public String  receberBar(@PathVariable Long idItem, Model model)
    {
        ItemDaConta atualizado = controleEntregaService.receberNoBar(idItem);
        model.addAttribute("itemAtualizado",atualizado);
        return "redirect:/controle-entrega";
    }

    @Transactional
    @PostMapping("/registrar")
    public String  registrarEntregaBar(@PathVariable Long idItem,Model model)
    {
        ItemDaConta atualizado = controleEntregaService.registrarEntregaFinalBar(idItem);
        model.addAttribute("itemregistrado",atualizado);
        return "redirect:/controle-entrega";
    }


}
