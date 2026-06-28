package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
