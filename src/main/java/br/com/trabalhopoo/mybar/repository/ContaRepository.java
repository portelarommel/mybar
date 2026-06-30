package br.com.trabalhopoo.mybar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.model.Conta;

import java.time.LocalDateTime;
import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByClienteCpfAndStatus(String cpf, Status status);
    boolean existsByNumero(Integer numero);

    List<Conta> findByAbertaFalseAndDataFechamentoBetweenOrderByDataFechamentoAsc(LocalDateTime inicio, LocalDateTime fim);
}
