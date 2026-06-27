package br.com.trabalhopoo.mybar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.model.ItemDaConta;

import java.util.List;


public interface ItemDaContaRepository extends JpaRepository<ItemDaConta, Long>{

    List<ItemDaConta> findByContaId(Long contaId);
}
