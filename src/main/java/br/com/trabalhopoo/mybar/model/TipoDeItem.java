package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoDeItem {
    @Id
    @Column(unique = true)
    private String codigo;
    private String descricao;
    private BigDecimal gorjeta;
    @Enumerated(EnumType.STRING)
    private Sentenca cozinha;
    @OneToMany
    private ItemDeCardapio itemDeCardapio;




}
