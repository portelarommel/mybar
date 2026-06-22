package br.com.trabalhopoo.mybar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.model.Configuracao;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
    Configuracao findFirstBy();
}
