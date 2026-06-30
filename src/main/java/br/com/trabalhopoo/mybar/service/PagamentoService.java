package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.Pagamento;
import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;
    private ContaRepository contaRepository;
    private UsuarioService usuarioService;

    public PagamentoService(PagamentoRepository iPagamento, ContaRepository iConta, UsuarioService usuarioService) {
        this.pagamentoRepository = iPagamento;
        this.contaRepository = iConta;
        this.usuarioService = usuarioService;
    }

    public Pagamento registrarPagamento(Long contaId, Pagamento pagamento) {

        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));

        if (conta.getStatus() != Status.ABERTA) {
            throw new IllegalStateException("Conta não está aberta.");
        }
        pagamento.setConta(conta);

        return pagamentoRepository.save(pagamento);
    }

    public void excluirPagamento(Long pagamentoId) {

        Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado."));
        pagamentoRepository.delete(pagamento);
    }


    public BigDecimal somarPagamentos(Long contaId) {
        List<Pagamento> pagamentos = pagamentoRepository.findByConta_Id(contaId);
        return pagamentos.stream()
                .map(Pagamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
