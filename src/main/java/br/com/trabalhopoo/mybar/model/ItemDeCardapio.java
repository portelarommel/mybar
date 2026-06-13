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
public class ItemDeCardapio {
    @Id
    @Column(unique = true)
    private String codigo;
    private String descricao;
    private BigDecimal valor;
    @OneToMany
    private ItensDaConta itensDaConta;
    @ManyToOne
    private TipoDeItem tipoDeItem;

}
