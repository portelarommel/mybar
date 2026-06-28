package br.com.trabalhopoo.mybar.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.model.enums.ModoOperacao;
import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.repository.ConfiguracaoRepository;

@Service
public class ConfiguracaoService {
    @Autowired
    public ConfiguracaoRepository configuracaoRepository;

    public Configuracao obterConfiguracao()
    {
        Configuracao config =  configuracaoRepository.findFirstBy();
        if(config == null)
        {
            config = new Configuracao();
            config.setModoOperacao(ModoOperacao.GESTAO);
            config.setValorIngressoMasc(BigDecimal.ZERO);
            config.setValorIngressoFemin(BigDecimal.ZERO);
            config = configuracaoRepository.save(config);
        }
        return config;
    }

    public Configuracao alterarValorIngresso(BigDecimal valorIngressoMasc, BigDecimal valorIngressoFem)
    {
        Configuracao config = obterConfiguracao();

        config.setValorIngressoMasc(valorIngressoMasc);
        config.setValorIngressoFemin(valorIngressoFem);
        config.setData(LocalDate.now());
        config.setHora(LocalTime.now());

        return configuracaoRepository.save(config);
    }

    public Configuracao liberarAtendimento() {
        Configuracao config = obterConfiguracao();
        config.setModoOperacao(ModoOperacao.ATENDIMENTO);
        config.setData(LocalDate.now());
        config.setHora(LocalTime.now());
        return configuracaoRepository.save(config);
    }

    public Configuracao fecharAtendimento() {
        Configuracao config = obterConfiguracao();
        config.setModoOperacao(ModoOperacao.GESTAO);
        config.setData(LocalDate.now());
        config.setHora(LocalTime.now());
        return configuracaoRepository.save(config);
    }
}