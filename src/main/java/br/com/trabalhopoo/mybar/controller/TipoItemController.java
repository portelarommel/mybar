package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.service.TipoItemService;
import org.springframework.web.bind.annotation.*;

import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.service.TipoItemService;

@Controller
@RequestMapping("/tipos-item")
public class TipoItemController {

    private final TipoItemService tipoItemService;
    public TipoItemController( TipoItemService tipoItemService)
    {
        this.tipoItemService = tipoItemService;
    }

    /*@GetMapping
    public ResponseEntity<List<TipoItem>> listarTiposItem()
    {
        return ResponseEntity.status(200).body(tipoItemService.listarTiposItem());
    }*/

    @GetMapping
    public String pesquisarTipoItem(@RequestParam(required = false) String descricao,Model model)
    {
        List<TipoItem> tipoitens = tipoItemService.pesquisarTipoItemPorFiltros(descricao);
        model.addAttribute("TipoItens",tipoitens);
        return "tipoDeItem/gestaoDeTipoDeItem";
    }
    @GetMapping("/{id}/editar")
    public String carregarPaginaEdicao(@PathVariable Long id,Model model)
    {
        TipoItem tipoItem = tipoItemService.pesquisarTipoItem(id);
        model.addAttribute("tipoItem",tipoItem);
        return "tipoDeItem/edicaoDeTipoDeItem";

    }
    @PostMapping("/{id}/editar")
    public String alterarTipoItem(@PathVariable Long id, @ModelAttribute TipoItem tipoItem)
    {
        tipoItem.setId(id);
        tipoItemService.alterarTipoItem(tipoItem);
        return "redirect:/tipos-item";
    }
    @GetMapping("/registro")
    public String carregarPaginaRegistro(Model model)
    {
        model.addAttribute("tipoItem",new TipoItem());
        return "tipoDeItem/registroDeTipoDeItem";


    }
    @PostMapping("/registro")
    public String registrarTipoItem(@ModelAttribute TipoItem tipoItem) {
        tipoItemService.registrarTipoItem(tipoItem);
        return "redirect:/tipos-item";
    }

    @PostMapping("/{id}/excluir")
    public String deletarTipoItem(@PathVariable Long id) {
        tipoItemService.deletarTipoItem(id);
        return "redirect:/tipos-item";
    }

    @GetMapping("/{id}/visualizar")
    public String visualizarTipoItem(@PathVariable Long id,Model model)
    {
        model.addAttribute("tipoItem",tipoItemService.pesquisarTipoItem(id));
        return "tipoDeItem/visualizacaoDeTipoDeItem";
    }
    
}