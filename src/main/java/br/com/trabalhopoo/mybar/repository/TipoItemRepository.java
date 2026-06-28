package br.com.trabalhopoo.mybar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.trabalhopoo.mybar.model.TipoItem;

public interface TipoItemRepository  extends JpaRepository<TipoItem, Long>{
    @Query("SELECT t FROM TipoItem t WHERE " +
           "(:descricao IS NULL OR LOWER(t.descricao) LIKE LOWER(CONCAT('%', :descricao, '%'))) " +
           "ORDER BY t.descricao ASC") 
    List<TipoItem> buscarComFiltros(@Param("descricao") String descricao);
    List<TipoItem> findByAtivoTrue();
}
