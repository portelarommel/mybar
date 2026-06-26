package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import br.com.trabalhopoo.mybar.enums.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.trabalhopoo.mybar.enums.Sentenca;

import java.math.BigDecimal;

@Entity
@Table(name="pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento forma;

    @Enumerated(EnumType.STRING)
    private Sentenca ativo;

    @ManyToOne
    private Usuario quemLancouPg;

    @ManyToOne
    private Usuario quemExcluiuPg;

    @ManyToOne
    private Conta conta;

    public Pagamento() {
    }

    public Pagamento(long id, BigDecimal valor, FormaDePagamento forma, Sentenca ativo, Usuario quemLancouPg, Usuario quemExcluiuPg, Conta conta) {
        id = id;
        this.valor = valor;
        this.forma = forma;
        this.ativo = ativo;
        this.quemLancouPg = quemLancouPg;
        this.quemExcluiuPg = quemExcluiuPg;
        this.conta = conta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public FormaDePagamento getForma() {
        return forma;
    }

    public void setForma(FormaDePagamento forma) {
        this.forma = forma;
    }

    public Sentenca getAtivo() {
        return ativo;
    }

    public void setAtivo(Sentenca ativo) {
        this.ativo = ativo;
    }

    public Usuario getQuemLancouPg() {
        return quemLancouPg;
    }

    public void setQuemLancouPg(Usuario quemLancouPg) {
        this.quemLancouPg = quemLancouPg;
    }

    public Usuario getQuemExcluiuPg() {
        return quemExcluiuPg;
    }

    public void setQuemExcluiuPg(Usuario quemExcluiuPg) {
        this.quemExcluiuPg = quemExcluiuPg;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
