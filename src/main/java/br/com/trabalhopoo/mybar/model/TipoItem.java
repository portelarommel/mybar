package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.util.List;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TiposItem")
public class TipoItem {
    @Id
    @Min(0)
    @Max(9999)
    private Integer codigo;
    private String descricao;
    private Boolean ativo = true;
    private BigDecimal gorjeta;
    @Enumerated(EnumType.STRING)
    private Sentenca cozinha;
    @OneToMany(mappedBy = "tipoItem")
    private List<ItemCardapio> itensCardapio;




}
