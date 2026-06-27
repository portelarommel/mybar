package br.com.trabalhopoo.mybar.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.model.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    List<ItemCardapio> findByAtivoTrue();
}
