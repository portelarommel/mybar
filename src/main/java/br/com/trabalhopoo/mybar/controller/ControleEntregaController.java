package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ControleEntregaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/ControleEntrega")
public class ControleEntregaController {
    @Autowired
    private ControleEntregaService controleEntregaService;

    @GetMapping("/buscar")
    public ResponseEntity<List<ItemDaConta>> buscarControleEntrega(
            @RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) String nomeCliente) {
            
        List<ItemDaConta> resultado = controleEntregaService.buscarItemDaConta(numeroConta, nomeCliente);
        return ResponseEntity.status(200).body(resultado);
    }
    @Transactional
    @PutMapping("/{idItem}/receberBar")
    public ResponseEntity<ItemDaConta>  receberBar(@PathVariable Long idItem)
    {
        ItemDaConta atualizado = controleEntregaService.receberNoBar(idItem);
        return ResponseEntity.status(200).body(atualizado);
    }

    @Transactional
    @PutMapping("/{idItem}/registrarEntrega")
    public ResponseEntity<ItemDaConta>  registrarEntregaBar(@PathVariable Long idItem)
    {
        ItemDaConta atualizado = controleEntregaService.registrarEntregaFinalBar(idItem);
        return ResponseEntity.status(200).body(atualizado);
    }


}
