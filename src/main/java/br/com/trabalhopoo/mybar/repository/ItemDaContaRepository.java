package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.enums.StatusItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.trabalhopoo.mybar.model.ItemDaConta;

import java.util.List;


public interface ItemDaContaRepository extends JpaRepository<ItemDaConta, Long>{
@Query("SELECT i FROM ItemDaConta i " +
       "JOIN i.conta c " +
       "JOIN c.cliente cl " +
       "JOIN i.itemCardapio ic " +
       "JOIN ic.tipoItem ti " +
       "WHERE (:numeroConta IS NULL OR c.numero = :numeroConta) " +
       "AND (:nomeCliente IS NULL OR LOWER(cl.nome) LIKE LOWER(CONCAT('%', :nomeCliente, '%'))) " +
       "AND i.status <> 'INTERNO' " +
       "AND ti.cozinha = false")
List<ItemDaConta> buscarParaControleEntregas(
        @Param("numeroConta") Integer numeroConta, 
        @Param("nomeCliente") String nomeCliente
    );
    List<ItemDaConta> findByContaId(Long contaId);

    List<ItemDaConta> findByItemCardapio_TipoItem_CozinhaTrueAndStatusInOrderByDataSolicitacaoAsc(List<StatusItem> status);
@Query("""
    SELECT i
    FROM ItemDaConta i
    JOIN i.conta c
    JOIN i.itemCardapio ic
    JOIN ic.tipoItem t
    WHERE (:numero IS NULL OR c.numero = :numero)
      AND (:status IS NULL OR i.status = :status)
      AND i.status IN (
            br.com.trabalhopoo.mybar.model.enums.StatusItem.SOLICITADO,
            br.com.trabalhopoo.mybar.model.enums.StatusItem.RECEBIDO,
            br.com.trabalhopoo.mybar.model.enums.StatusItem.ENTREGUE
      )
      AND t.cozinha = true
    ORDER BY
      CASE i.status
          WHEN br.com.trabalhopoo.mybar.model.enums.StatusItem.SOLICITADO THEN 1
          WHEN br.com.trabalhopoo.mybar.model.enums.StatusItem.RECEBIDO THEN 2
          WHEN br.com.trabalhopoo.mybar.model.enums.StatusItem.ENTREGUE THEN 3
      END
""")
List<ItemDaConta> buscarParaCozinha(
        @Param("numero") Integer numero,
        @Param("status") StatusItem status
);
}
