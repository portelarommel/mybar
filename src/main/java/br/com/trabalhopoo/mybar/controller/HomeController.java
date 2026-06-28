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
    @GetMapping("/conta/registroDeConta")
    public String registroDeConta()
    {
        return "conta/registroDeConta";
    }
    @GetMapping("/conta/fechamentoDeConta")
    public String fechamentoDeConta()
    {
        return "conta/fechamentoDeConta";
    }
}
