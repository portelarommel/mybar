package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ControleEntregaService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/ControleEntrega")
public class ControleEntregaController {
    @Autowired
    private ControleEntregaService controleEntregaService;

    @GetMapping
    public String buscarControleEntrega(
            @RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) String nomeCliente) {
            
        List<ItemDaConta> resultado = controleEntregaService.buscarItemDaConta(numeroConta, nomeCliente);
        return "gestaoDeControleDeEntrega";
    }
    @Transactional
    @PutMapping
    public String  receberBar(@PathVariable Long idItem)
    {
        ItemDaConta atualizado = controleEntregaService.receberNoBar(idItem);
        return "gestaoDeControleDeEntrega";
    }

    @Transactional
    @PutMapping("/registrar")
    public String  registrarEntregaBar(@PathVariable Long idItem)
    {
        ItemDaConta atualizado = controleEntregaService.registrarEntregaFinalBar(idItem);
        return "gestaoDeControleDeEntrega";
    }


}
