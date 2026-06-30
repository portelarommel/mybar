package br.com.trabalhopoo.mybar.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.model.enums.ModoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.service.ConfiguracaoService;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {

    private final ConfiguracaoService configuracaoService;
    public ConfiguracaoController(ConfiguracaoService configuracaoService)
    {
        this.configuracaoService = configuracaoService;
    }

    @GetMapping
    public ResponseEntity<Configuracao> buscarAtual() {
        return ResponseEntity.ok(configuracaoService.obterConfiguracao());
    }

    @PutMapping("/ingressos")
    public ResponseEntity<Configuracao> alterarValorIngresso(@RequestParam BigDecimal valorIngressoMasc, @RequestParam BigDecimal valorIngressoFemin)
    {
        return ResponseEntity.status(200).body(configuracaoService.alterarValorIngresso(valorIngressoMasc,valorIngressoFemin));
    }

    @PutMapping("/liberar")
    public ResponseEntity<Configuracao> liberarAtendimento() {
        return ResponseEntity.ok(configuracaoService.liberarAtendimento());
    }

    @PutMapping("/fechar")
    public ResponseEntity<Configuracao> fecharAtendimento() {
        return ResponseEntity.ok(configuracaoService.fecharAtendimento());
    }
}

