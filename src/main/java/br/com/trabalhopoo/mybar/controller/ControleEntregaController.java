package br.com.trabalhopoo.mybar.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.trabalhopoo.mybar.dto.ItemDaContaEntregaDto;
import br.com.trabalhopoo.mybar.dto.ItemDaContaDto;
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
        List<ItemDaContaEntregaDto> resultadoDto =resultado.stream()
    .map((ItemDaConta item) -> {
        return new ItemDaContaEntregaDto(
            item.getId(),
            item.getConta().getNumero(),
            item.getItemCardapio().getTipoItem().getDescricao(),
            item.getItemCardapio().getDescricao(),
            item.getDataHora(),
            item.getStatus()

        );}).collect(Collectors.toList());
        model.addAttribute("itens", resultadoDto);
        return "gestaoDeControleDeEntrega";
    }
    @Transactional
    @PostMapping("/{id}/receber")
    public String  receberBar(@PathVariable Long id, Model model)
    {
        ItemDaConta atualizado = controleEntregaService.receberNoBar(id);
        model.addAttribute("itemAtualizado",atualizado);
        return "redirect:/controle-entrega";
    }

    @Transactional
    @PostMapping("/{id}/registrar")
    public String  registrarEntregaBar(@PathVariable Long id,Model model)
    {
        ItemDaConta atualizado = controleEntregaService.registrarEntregaFinalBar(id);
        model.addAttribute("itemregistrado",atualizado);
        return "redirect:/controle-entrega";
    }


}
