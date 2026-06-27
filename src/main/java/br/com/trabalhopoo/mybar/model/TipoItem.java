package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.util.List;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TiposItem")
public class TipoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Boolean ativo = true;

    private BigDecimal gorjeta;

    @Enumerated(EnumType.STRING)
    private Sentenca cozinha;

    @OneToMany(mappedBy = "tipoItem")
    private List<ItemCardapio> itensCardapio;

    public TipoItem() {
    }

    public TipoItem(Long id, String descricao, BigDecimal gorjeta, Sentenca cozinha, List<ItemCardapio> itensCardapio) {
        this.id = id;
        this.descricao = descricao;
        this.gorjeta = gorjeta;
        this.cozinha = cozinha;
        this.itensCardapio = itensCardapio;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta(BigDecimal gorjeta) {
        this.gorjeta = gorjeta;
    }

    public Sentenca getCozinha() {
        return cozinha;
    }

    public void setCozinha(Sentenca cozinha) {
        this.cozinha = cozinha;
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void setItensCardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }
}
