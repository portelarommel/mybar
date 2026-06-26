package br.com.trabalhopoo.mybar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.model.TipoItem;

public interface TipoItemRepository  extends JpaRepository<TipoItem, Long>{
    List<TipoItem> findByAtivoTrue();
}
