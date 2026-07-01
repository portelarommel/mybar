package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


    List<Pagamento> findByConta_Id(Long contaId);
}
