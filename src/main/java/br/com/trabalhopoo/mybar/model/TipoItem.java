package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.util.List;

import br.com.trabalhopoo.mybar.model.enums.Sentenca;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tipos_item")
public class TipoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "gorjeta", nullable = false)
    private BigDecimal gorjeta;

    @Enumerated(EnumType.STRING)
    @Column(name = "cozinha", nullable = false)
    private Sentenca cozinha;

    @OneToMany(mappedBy = "tipoItem", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemCardapio> itensCardapio;

    public TipoItem() {
    }

    public TipoItem(Long id, String descricao, String codigo, Boolean ativo, BigDecimal gorjeta, Sentenca cozinha, List<ItemCardapio> itensCardapio) {
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
        this.ativo = ativo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
