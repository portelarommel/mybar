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



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itensCardapio")
public class ItemCardapio {
    @Id
    @Min(0)
    @Max(9999)
    private Integer codigo;
    @Column(length = 255)
    private String descricao;
    private boolean ativo = true;
    private BigDecimal valor;
    @OneToMany(mappedBy ="itemCardapio")
    private List<ItemDaConta> itensDaConta;
    @ManyToOne
    private TipoItem tipoDeItem;

}
