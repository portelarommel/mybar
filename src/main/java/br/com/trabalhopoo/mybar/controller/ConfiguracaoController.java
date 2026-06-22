package br.com.trabalhopoo.mybar.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.service.ConfiguracaoService;

@Controller
@RequestMapping("/configuracao")
public class ConfiguracaoController {
    @Autowired
    private final ConfiguracaoService configuracaoService;
    public ConfiguracaoController(ConfiguracaoService configuracaoService)
    {
        this.configuracaoService = configuracaoService;
    }
    @PutMapping("/ingressos")
    public ResponseEntity<Configuracao> alterarValorIngresso(@RequestParam BigDecimal valorIngressoMasc, @RequestParam BigDecimal valorIngressoFemin)
    {
        return ResponseEntity.status(200).body(configuracaoService.alterarValorIngresso(valorIngressoMasc,valorIngressoFemin));
    }
    @PutMapping ("/modoOperacao")
    public ResponseEntity<Configuracao> alterarModoOperacao(@RequestParam LocalDate data,@RequestParam LocalTime hora)
    {
        return ResponseEntity.status(200).body(configuracaoService.alterarModoOperacao(data, hora));
    }


}
