package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
