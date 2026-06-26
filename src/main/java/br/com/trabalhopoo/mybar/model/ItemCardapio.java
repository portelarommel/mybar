package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "itensCardapio")
public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private boolean ativo = true;

    private BigDecimal valor;

    @OneToMany(mappedBy ="itemCardapio")
    private List<ItemDaConta> itensDaConta;

    @ManyToOne
    private TipoItem tipoItem;

    public ItemCardapio() {
    }

    public ItemCardapio(Long id, String descricao, boolean ativo, BigDecimal valor, List<ItemDaConta> itensDaConta, TipoItem tipoItem) {
        this.id = id;
        this.descricao = descricao;
        this.ativo = ativo;
        this.valor = valor;
        this.itensDaConta = itensDaConta;
        this.tipoItem = tipoItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ItemDaConta> getItensDaConta() {
        return itensDaConta;
    }

    public void setItensDaConta(List<ItemDaConta> itensDaConta) {
        this.itensDaConta = itensDaConta;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
}
