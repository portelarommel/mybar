package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.service.TipoItemService;

@RestController
@RequestMapping("/tiposItem")
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

    @GetMapping("/{id}")
    public ResponseEntity<TipoItem> pesquisarTipoItem(@PathVariable Long id)
    {
        return ResponseEntity.status(200).body(tipoItemService.pesquisarTipoItem(id));
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