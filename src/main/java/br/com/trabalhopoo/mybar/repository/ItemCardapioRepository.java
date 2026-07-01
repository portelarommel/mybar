package br.com.trabalhopoo.mybar.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.trabalhopoo.mybar.model.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    @Query("SELECT i FROM ItemCardapio i WHERE " +
           "(:codigo IS NULL OR i.id = :codigo) AND " +
           "(:descricao IS NULL OR LOWER(i.descricao) LIKE LOWER(CONCAT('%', :descricao, '%'))) AND " +
           "(:tipoItemId IS NULL OR i.tipoItem.id = :tipoItemId) " +
           "ORDER BY i.descricao ASC")
    List<ItemCardapio> buscarComFiltrosDeTela(
            @Param("codigo") Long codigo,
            @Param("descricao") String descricao,
            @Param("tipoItemId") Long tipoItemId);
    List<ItemCardapio> findByAtivoTrue();
    Optional<ItemCardapio> findByCodigo(Integer codigo);
}
