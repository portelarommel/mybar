package br.com.trabalhopoo.mybar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contas")
public class ContaController {
    @GetMapping
    public String registroContas()
    {
        return "";
    }
    @PutMapping("/editar/{numero}")
    public String editarConta(@PathVariable Integer numero)
    {
        return "";
        
    }
    @PostMapping("/registrar")
    public String registrarConta()
    {
        return "";
    }
    @DeleteMapping("/fechamento/{numero}")
    public String fechamentoConta(@PathVariable Integer numero)
    {
        return "";
    }



}
