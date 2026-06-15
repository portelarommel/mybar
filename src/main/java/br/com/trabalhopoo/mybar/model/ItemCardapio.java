package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemCardapio {
    @Id
    @Column(unique = true)
    private String codigo;
    private String descricao;
    private BigDecimal valor;
    @OneToMany
    private ItemDaConta itensDaConta;
    @ManyToOne
    private TipoItem tipoDeItem;

}
