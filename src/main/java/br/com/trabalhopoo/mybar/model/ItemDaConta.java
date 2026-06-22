package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "ItensDaconta")
public class ItemDaConta {
    public ItemDaConta(ItemCardapio itemCardapio, int quantidade)
    {
        this.quantidade = quantidade;
        this.itemCardapio = itemCardapio;
        valor = itemCardapio.getValor().multiply(BigDecimal.valueOf(quantidade));
    }
        public ItemDaConta(BigDecimal valor)
    {
        this.valor = valor;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal valor;
    private int quantidade;
    @Enumerated(EnumType.STRING)
    private Sentenca ativo;
    private LocalDate dataSolicitacao;
    private LocalTime horaSolicitacao;
    private LocalDate dataRecebimentoCozinha;
    private LocalTime horaRecebimentoCozinha;
    private LocalDate dataEntregaCozinha;
    private LocalTime horaEntregaCozinha;
    private LocalDate dataRecebimentoBar;
    private LocalTime horaRecebimentoBar;
    private LocalDate dataEntregaBar;
    private LocalTime horaEntregaBar;
    @OneToOne 
    private Usuario quemRemoveu;
    @ManyToOne
    private Usuario quemLancou;
    @ManyToOne
    private ItemCardapio itemCardapio;
    @ManyToOne
    private Conta conta;

}
