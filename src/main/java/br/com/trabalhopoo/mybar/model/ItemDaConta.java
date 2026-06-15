package br.com.trabalhopoo.mybar.model;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import jakarta.persistence.*;
public class ItensDaConta {
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
