package br.com.trabalhopoo.mybar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.service.TipoItemService;
@Controller
@RequestMapping("tiposItem")
public class TipoItemController {
    @Autowired
    private final TipoItemService tipoItemService;
    public TipoItemController( TipoItemService tipoItemService)
    {
        this.tipoItemService = tipoItemService;
    }
        @GetMapping
    public ResponseEntity<List<TipoItem>> listarTiposItem()
    {
        return ResponseEntity.status(200).body(tipoItemService.listarTiposItem());
    }

    @GetMapping 
    public ResponseEntity<TipoItem> buscarTipoItem(@PathVariable Integer codigo)
    {
        return ResponseEntity.status(200).body(tipoItemService.buscarTipoItem(codigo));

    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TipoItem> editarTipoItem(@PathVariable Integer codigo, @RequestBody TipoItem tipoItem)
    {
        return ResponseEntity.status(200).body(tipoItemService.editarTipoItem(tipoItem));

    }
    @PostMapping("/registrar")
    public ResponseEntity<TipoItem> registrarTipoItem(@RequestBody TipoItem tipoItem)
    {
        return ResponseEntity.status(200).body(tipoItemService.registrarTipoItem(tipoItem));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarTipoItem(@PathVariable Integer codigo)
    {
        return ResponseEntity.status(201).body(tipoItemService.deletarTipoItem(codigo));

    }


    
}
