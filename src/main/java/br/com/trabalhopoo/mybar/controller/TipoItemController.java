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

@RestController
@RequestMapping("/tipos-item")
public class TipoItemController {

    private final TipoItemService tipoItemService;
    public TipoItemController( TipoItemService tipoItemService)
    {
        this.tipoItemService = tipoItemService;
    }

    @GetMapping()
    public ResponseEntity<List<TipoItem>> listarTiposItem()
    {
        return ResponseEntity.status(200).body(tipoItemService.listarTiposItem());
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<TipoItem>> pesquisarTipoItem(@RequestParam(required = false) String descricao)
    {
        return ResponseEntity.status(200).body(tipoItemService.pesquisarTipoItemPorFiltros(descricao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoItem> alterarTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItem)
    {
        tipoItem.setId(id);
        return ResponseEntity.status(200).body(tipoItemService.alterarTipoItem(tipoItem));
    }

    @PostMapping()
    public ResponseEntity<TipoItem> registrarTipoItem(@RequestBody TipoItem tipoItem) {
        return ResponseEntity.status(200).body(tipoItemService.registrarTipoItem(tipoItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTipoItem(@PathVariable Long id) {
        tipoItemService.deletarTipoItem(id);
        return ResponseEntity.status(201).build();
    }
}