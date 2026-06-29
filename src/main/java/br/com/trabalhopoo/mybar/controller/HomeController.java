package br.com.trabalhopoo.mybar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/conta")
    public String contas()
    {
        return "conta/gestaoDeContas";
    }
    @GetMapping("/conta/edicaoDeConta")
    public String edicaoContas()
    {
        return "conta/edicaoDeConta";
    }
    @GetMapping("/conta/registroDeItemDeConta")
    public String registroDeItemDeConta()
    {
        return "conta/registroDeItemConta";
    }
    @GetMapping("/conta/registro")
    public String registroDeConta()
    {
        return "conta/registroDeConta";
    }
    @GetMapping("/conta/visualizacao")
    public String visualizacaoDeConta()
    {
        return "conta/visualizacaoDeConta";
    }
    @GetMapping("/conta/fechamentoDeConta")
    public String fechamentoDeConta()
    {
        return "conta/fechamentoDeConta";
    }
    @GetMapping("/itemCardapio")
    public String gestaoDeItemCardapio()
    {
        return "itemCardapio/gestaoDeItemCardapio";
    }
    @GetMapping("/itemCardapio/registro")
    public String registroDeItemCardapio()
    {
        return "itemCardapio/registroDeItemCardapio";
    }
    @GetMapping("/itemCardapio/visualizar")
    public String visualizacaoDeItemCardapio()
    {
        return "itemCardapio/visualizacaoDeItemCardapio";

    }
    @GetMapping("/tipoItem")
    public String gestaoDeTipoDeItem()
    {
        return "tipoDeItem/gestaoTipoDeItem";
    }
    @GetMapping("/tipoItem/registro")
    public String registroDeTipoDeItem()
    {
        return "tipoDeItem/registroDeTipoDeItem";
    }
    @GetMapping("/tipoItem/edicao")
    public String edicaoDeTipoDeItem()
    {
        return "tipoDeItem/edicaoDeTipoDeItem";
    }
    @GetMapping("/tipoItem/visualizacao")
    public String visualizacaoDeTipoDeItem()
    {
        return "tipoDeItem/visualizacaoDeTipoDeItem";
    }
    @GetMapping("/controleDeEntrega")
    public String gestaoDeControleDeEntrega()
    {
        return "gestaoDeControleDeEntrega";
    }
    @GetMapping("/configuracaoDeSistema")
    public String gestaoDeConfiguracao()
    {
        return "gestaoDeConfiguracao";
    }
    @GetMapping("/usuarios")
    public String gestaoDeUsuario()
    {
        return "usuario/gestaoDeUsuario";
    }
    @GetMapping("/usuarios/edicao")
    public String edicaoDeUsuario()
    {
        return "usuario/edicaoDeUsuario";
    }
    @GetMapping("/usuarios/registro")
    public String registroDeUsuario()
    {
        return "usuario/registroDeUsuario";
    }
    @GetMapping("/usuarios/visualizacao")
    public String visualizacaoDeUsuario()
    {
        return "usuario/visualizacaoDeUsuario";
    }
    @GetMapping("/controleDeCozinha")
    public String controleDeCozinha()
    {
        return "gestaoDeControleDeCozinha";
    }
    @GetMapping("/dashboard")
    public String dashboard()
    {
        return "dashboard";
    }
}