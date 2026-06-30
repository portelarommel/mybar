package br.com.trabalhopoo.mybar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.model.Conta;

import java.time.LocalDateTime;
import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query("SELECT c FROM Conta c WHERE " +
           "(:numero IS NULL OR c.numero = :numero) AND " +
           "(:cpf IS NULL OR c.cliente.cpf = :cpf) AND " +
           "(:nome IS NULL OR LOWER(c.cliente.nome) LIKE LOWER(CONCAT('%', :nome, '%'))) AND " +
           "(:status IS NULL OR c.status = :status)"+
           "ORDER BY c.cliente.nome ASC")
    List<Conta> buscarComFiltros(
            @Param("numero") Integer numero,
            @Param("cpf") String cpf,
            @Param("nome") String nome,
            @Param("status") Status status);

    boolean existsByClienteCpfAndStatus(String cpf, Status status);
    boolean existsByNumero(Integer numero);

    List<Conta> findByAbertaFalseAndDataFechamentoBetweenOrderByDataFechamentoAsc(LocalDateTime inicio, LocalDateTime fim);
}
