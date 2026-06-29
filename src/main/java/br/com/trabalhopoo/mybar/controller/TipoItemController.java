package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String pesquisarTipoItem(@RequestParam(required = false) String descricao)
    {
        tipoItemService.pesquisarTipoItemPorFiltros(descricao);
        return "tipoDeItem/gestaoDeTipoDeItem";
    }

    @PutMapping("/{id}/editar")
    public String alterarTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItem)
    {
        tipoItem.setId(id);
        tipoItemService.alterarTipoItem(tipoItem);
        return "tipoDeItem/edicaoDeTipoDeItem";
    }

    @PostMapping("/registro")
    public String registrarTipoItem(@RequestBody TipoItem tipoItem) {
        tipoItemService.registrarTipoItem(tipoItem);
        return "tipoDeItem/registroDeTipoDeItem";
    }

    @DeleteMapping("/{id}/excluir")
    public String deletarTipoItem(@PathVariable Long id) {
        tipoItemService.deletarTipoItem(id);
        return "redirect:/tipos-item";
    }
}