package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.dto.ItemDaContaEntregaDto;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.model.enums.StatusItem;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import br.com.trabalhopoo.mybar.service.CozinhaService;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cozinha")
public class CozinhaController {
    private CozinhaService cozinhaService;
    public CozinhaController(CozinhaService cozinhaService)
    {
        this.cozinhaService =cozinhaService;
    }
    @GetMapping 
    public String buscarCozinha(@RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) StatusItem statusItem,
            Model model)
    {
        List<ItemDaConta> resultado = cozinhaService.buscarComFiltros(numeroConta, statusItem);
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
        return "gestaoDeControleDeCozinha";

    }
    @Transactional
    @PostMapping("/{id}/receber")
    public String  receberBar(@PathVariable Long id, Model model)
    {
        ItemDaConta atualizado = cozinhaService.receberPedido(id);
        model.addAttribute("itemAtualizado",atualizado);
        return "redirect:/cozinha";
    }

    @Transactional
    @PostMapping("/{id}/registrar")
    public String  registrarEntregaBar(@PathVariable Long id,Model model)
    {
        ItemDaConta atualizado = cozinhaService.entregarPedido(id);
        model.addAttribute("itemregistrado",atualizado);
        return "redirect:/cozinha";
    }




}
