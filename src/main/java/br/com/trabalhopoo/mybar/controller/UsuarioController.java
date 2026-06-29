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

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /*@GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }*/

    @GetMapping
    public String pesquisarUsuario(@RequestParam(required = false) String nome) {
        return "usuario/gestaoDeUsuario";
    }

    @PostMapping("/registro")
    public String incluirUsuario(@RequestBody Usuario usuario) {
        Usuario criado = usuarioService.incluirUsuario(usuario);
        return "usuario/registroDeUsuario";
    }

    @PutMapping("/{id}/editar")
    public String alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return "usuario/edicaoDeUsuario";
    }

    @DeleteMapping("/{id}/excluir")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/usuario";
    }
}
