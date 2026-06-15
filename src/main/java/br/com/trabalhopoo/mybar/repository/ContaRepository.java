package br.com.trabalhopoo.mybar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhopoo.mybar.enums.Status;
import br.com.trabalhopoo.mybar.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    boolean existsByClienteCpfAndStatus(String cpf, Status status);
}
