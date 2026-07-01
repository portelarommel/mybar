package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.dto.UsuarioDto;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String pesquisarUsuario(@RequestParam(required = false) String nome, Model model) {
        List<Usuario> usuarios= usuarioService.pesquisarUsuarioPorFiltro(nome);

        model.addAttribute("usuarios", usuarios);
        return "usuario/gestaoDeUsuario";
    }

    @GetMapping("/registrar")
    public String carregarPaginaRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/registroDeUsuario";
    }

    @PostMapping("/registrar")
    public String incluirUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.incluirUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/{id}/editar")
    public String carregarPaginaEdicao(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.pesquisarUsuario(id);
        model.addAttribute("usuario", usuario);
        return "usuario/edicaoDeUsuario";
    }

    @PostMapping("/{id}/editar")
    public String alterarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {
        usuarioService.alterarUsuario(id, usuario);
        return "redirect:/usuarios";
    }
    @GetMapping("/{id}/visualizar")
    public String visualizarUsuario(@PathVariable Long id, Model model)
    {
        Usuario usuario = usuarioService.pesquisarUsuario(id);
        model.addAttribute("usuario",usuario);
        return "usuario/visualizacaoDeUsuario";
    }

    @PostMapping("/{id}/excluir")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/usuarios";
    }

}
