package br.com.trabalhopoo.mybar.controller;

import org.springframework.stereotype.Controller;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.model.Usuario;
import br.com.trabalhopoo.mybar.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Usuario>> pesquisarUsuario(@RequestParam(required = false) String nome) {
        return ResponseEntity.ok(usuarioService.pesquisarUsuarioPorFiltro(nome));
    }

    @PostMapping
    public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario) {
        Usuario criado = usuarioService.incluirUsuario(usuario);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.alterarUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
