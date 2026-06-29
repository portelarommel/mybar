package br.com.trabalhopoo.mybar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
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
    @GetMapping("/registrar")
    public String carregarPaginaRegistro(Model model)
    {
        model.addAttribute("novo",new Usuario());
        return "usuario/registroDeUsuario";

    }
    @PostMapping("/registrar")
    public String incluirUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.incluirUsuario(usuario);
        return "redirect:/usuario";
    }
    @GetMapping("/{id}/editar")
    public String carregarPaginaEdicao(@PathVariable Long id , Model model)
    {
        Usuario usuario = usuarioService.pesquisarUsuario(id);
        model.addAttribute("editar",usuario);
        return "usuario/registroDeUsuario";

    }
    @PutMapping("/{id}/editar")
    public String alterarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuarioService.alterarUsuario(id, usuario);
        return "redirect:/usuario";
    }

    @DeleteMapping("/{id}/excluir")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/usuario";
    }
}
