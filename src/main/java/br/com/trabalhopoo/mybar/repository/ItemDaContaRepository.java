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
           "WHERE (:numeroConta IS NULL OR c.numero = :numeroConta) " +
           "AND (:nomeCliente IS NULL OR LOWER(cl.nome) LIKE LOWER(CONCAT('%', :nomeCliente, '%')))")
    List<ItemDaConta> buscarParaControleEntregas(
        @Param("numeroConta") Integer numeroConta, 
        @Param("nomeCliente") String nomeCliente
    );
    List<ItemDaConta> findByContaId(Long contaId);

    List<ItemDaConta> findByConta_IdOrderByDataSolicitacaoAsc(Long contaId);

    List<ItemDaConta> findByItemCardapio_TipoItem_CozinhaTrueAndStatusInOrderByDataRecebimentoCozinhaAsc(
            List<StatusItem> statuses
    );
}
