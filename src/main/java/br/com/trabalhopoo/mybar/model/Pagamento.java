package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import br.com.trabalhopoo.mybar.model.enums.FormaDePagamento;
import br.com.trabalhopoo.mybar.model.enums.Sentenca;

import java.math.BigDecimal;

@Entity
@Table(name="pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma", nullable = false)
    private FormaDePagamento forma;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "quem_lancou_pg_id")
    private Usuario quemLancouPg;

    @ManyToOne
    @JoinColumn(name = "quem_excluiu_pg_id")
    private Usuario quemExcluiuPg;

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    public Pagamento() {
    }

    public Pagamento(Long id, BigDecimal valor, FormaDePagamento forma, Boolean ativo, Usuario quemLancouPg, Usuario quemExcluiuPg, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.forma = forma;
        this.ativo = ativo;
        this.quemLancouPg = quemLancouPg;
        this.quemExcluiuPg = quemExcluiuPg;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
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
