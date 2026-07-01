package br.com.trabalhopoo.mybar.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.model.enums.ModoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.service.ConfiguracaoService;


@Controller
@RequestMapping("/configuracao")
public class ConfiguracaoController {

    private final ConfiguracaoService configuracaoService;
    public ConfiguracaoController(ConfiguracaoService configuracaoService)
    {
        this.configuracaoService = configuracaoService;
    }

    @GetMapping
    public String buscarAtual(Model model) {
        model.addAttribute("configuracao",configuracaoService.obterConfiguracao());
        //model.addAttribute("ModoOperacao", br.com.trabalhopoo.mybar.model.enums.ModoOperacao.class);
        return "/gestaoDeConfiguracao";
    }

    @PostMapping("/ingressos")
    public String alterarValorIngresso(@RequestParam BigDecimal valorIngressoMasc, @RequestParam BigDecimal valorIngressoFemin)
    {
        return "redirect:/configuracao";
    }

    @PostMapping("/liberar")
    public String liberarAtendimento() {
        return "redirect:/configuracao";
    }

    @PostMapping("/fechar")
    public String fecharAtendimento() {
        return "redirect:/configuracao";
    }
}

