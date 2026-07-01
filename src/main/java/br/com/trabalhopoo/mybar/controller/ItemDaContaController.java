package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.dto.ItemDaContaDto;
import br.com.trabalhopoo.mybar.exception.ContaJaFechadaException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.service.ContaService;
import br.com.trabalhopoo.mybar.service.ItemDaContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.List;

@Controller
@RequestMapping("/contas")
public class ItemDaContaController {

    private final ItemDaContaService itemDaContaService;
    private final ContaService contaService;
    public ItemDaContaController(ItemDaContaService itemDaContaService, ContaService contaService) {
        this.itemDaContaService = itemDaContaService;
        this.contaService = contaService;
    }

    @PostMapping("/{id}/registrar")
    public String registrarItemConta(@PathVariable Long id, @ModelAttribute ItemDaContaDto itemDaContaDto){
        itemDaContaService.registrarItemConta(id, itemDaContaDto);
        return "redirect:/contas/"+id+"/itens";
    }

    @GetMapping("/{id}/itens")
    public String carregarPaginaItemConta(@PathVariable Long id, Model model) {
        Conta conta = contaService.pesquisarConta(id);
        if(conta.getStatus() == Status.FECHADA)
        {
            throw new ContaJaFechadaException("Conta já foi fechada!", id);
        }
        model.addAttribute("conta",conta);
        List<ItemDaConta> itensDaConta =  itemDaContaService.listarPorConta(id);
        List<ItemDaContaDto> itensDaContaDto = itensDaConta.stream()
    .map((ItemDaConta item) -> {
        return new ItemDaContaDto(
            item.getId(),
            item.getQuantidade(),
            item.getCodigo(),
            item.getItemCardapio().getDescricao(),
            item.getItemCardapio().getValor()

        );}).collect(Collectors.toList());
        model.addAttribute("itens", itensDaContaDto);
        return "conta/registroDeItemConta" ;
    }

    @DeleteMapping("/{id}/item/{itemId}")
    public String excluirItem(@PathVariable Long id, @PathVariable Long itemId) {
        itemDaContaService.excluirItem(id, itemId);
        return "redirect:/contas/"+id+"/itens";
    }
}
