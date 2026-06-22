package br.com.trabalhopoo.mybar.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.trabalhopoo.mybar.enums.ModoOperacao;
import br.com.trabalhopoo.mybar.model.Configuracao;
import br.com.trabalhopoo.mybar.repository.ConfiguracaoRepository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

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
        Configuracao nova = obterConfiguracao();
        if(nova.getValorIngressoMasc().compareTo(valorIngressoMasc) != 0)
        {
            nova.setValorIngressoMasc(valorIngressoMasc);
        }
        if(nova.getValorIngressoFemin().compareTo(valorIngressoFem) != 0 )
        {
            nova.setValorIngressoFemin(valorIngressoFem);
        }
        return nova;
    }
    public Configuracao alterarModoOperacao(LocalDate data, LocalTime hora)
    {
        Configuracao nova = obterConfiguracao();
        if(nova.getModoOperacao() == ModoOperacao.GESTAO)
        {
            nova.setModoOperacao(ModoOperacao.ATENDIMENTO);
        }
        else
        {
            nova.setModoOperacao(ModoOperacao.GESTAO);
        }
        nova.setData(data);
        nova.setHora(hora);
        return nova;
    }

    

}
