package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.Pagamento;
import br.com.trabalhopoo.mybar.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/{contaId}")
    public ResponseEntity<Pagamento> registrarPagamento(
            @PathVariable Long contaId,
            @RequestBody Pagamento pagamento) {

        return ResponseEntity.status(201)
                .body(pagamentoService.registrarPagamento(contaId, pagamento));
    }

    @DeleteMapping("/{pagamentoId}")
    public ResponseEntity<?> excluirPagamento(
            @PathVariable Long pagamentoId) {

        pagamentoService.excluirPagamento(pagamentoId);
        return ResponseEntity.status(204).build();
    }

   /* @GetMapping("/{contaId}/total")
    public ResponseEntity<BigDecimal> totalPagamentos(@PathVariable Long contaId) {
        return ResponseEntity.ok(pagamentoService.somarPagamentos(contaId));
    }*/
}
