package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "itens_cardapio")
public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero", nullable = false, unique = true, length = 4)
    private Integer codigo;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @OneToMany(mappedBy ="itemCardapio")
    @JsonIgnore
    private List<ItemDaConta> itensDaConta;

    @ManyToOne
    @JoinColumn(name = "tipo_item_id", nullable = false)
    @JsonBackReference
    private TipoItem tipoItem;

    public ItemCardapio() {
    }

    public ItemCardapio(Long id, String descricao, Boolean ativo, BigDecimal valor, List<ItemDaConta> itensDaConta, TipoItem tipoItem) {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
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
    public Integer getCodigo()
    {
        return codigo;
    }
    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;

    }
}
