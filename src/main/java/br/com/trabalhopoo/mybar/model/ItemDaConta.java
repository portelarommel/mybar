package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.enums.Sentenca;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ItensDaconta")
public class ItemDaConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor; // nao tem no pdf mas vou analisar dps

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
    @JsonIgnore
    private Conta conta;

    public ItemDaConta() {
    }


    public ItemDaConta(Long id, BigDecimal valor, int quantidade, Sentenca ativo, LocalDate dataSolicitacao, LocalTime horaSolicitacao, LocalDate dataRecebimentoCozinha, LocalTime horaRecebimentoCozinha, LocalDate dataEntregaCozinha, LocalTime horaEntregaCozinha, LocalDate dataRecebimentoBar, LocalTime horaRecebimentoBar, LocalDate dataEntregaBar, LocalTime horaEntregaBar, Usuario quemRemoveu, Usuario quemLancou, ItemCardapio itemCardapio, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.dataSolicitacao = dataSolicitacao;
        this.horaSolicitacao = horaSolicitacao;
        this.dataRecebimentoCozinha = dataRecebimentoCozinha;
        this.horaRecebimentoCozinha = horaRecebimentoCozinha;
        this.dataEntregaCozinha = dataEntregaCozinha;
        this.horaEntregaCozinha = horaEntregaCozinha;
        this.dataRecebimentoBar = dataRecebimentoBar;
        this.horaRecebimentoBar = horaRecebimentoBar;
        this.dataEntregaBar = dataEntregaBar;
        this.horaEntregaBar = horaEntregaBar;
        this.quemRemoveu = quemRemoveu;
        this.quemLancou = quemLancou;
        this.itemCardapio = itemCardapio;
        this.conta = conta;
    }

    public ItemDaConta(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Sentenca getAtivo() {
        return ativo;
    }

    public void setAtivo(Sentenca ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalTime getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(LocalTime horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    public LocalDate getDataRecebimentoCozinha() {
        return dataRecebimentoCozinha;
    }

    public void setDataRecebimentoCozinha(LocalDate dataRecebimentoCozinha) {
        this.dataRecebimentoCozinha = dataRecebimentoCozinha;
    }

    public LocalTime getHoraRecebimentoCozinha() {
        return horaRecebimentoCozinha;
    }

    public void setHoraRecebimentoCozinha(LocalTime horaRecebimentoCozinha) {
        this.horaRecebimentoCozinha = horaRecebimentoCozinha;
    }

    public LocalDate getDataEntregaCozinha() {
        return dataEntregaCozinha;
    }

    public void setDataEntregaCozinha(LocalDate dataEntregaCozinha) {
        this.dataEntregaCozinha = dataEntregaCozinha;
    }

    public LocalTime getHoraEntregaCozinha() {
        return horaEntregaCozinha;
    }

    public void setHoraEntregaCozinha(LocalTime horaEntregaCozinha) {
        this.horaEntregaCozinha = horaEntregaCozinha;
    }

    public LocalDate getDataRecebimentoBar() {
        return dataRecebimentoBar;
    }

    public void setDataRecebimentoBar(LocalDate dataRecebimentoBar) {
        this.dataRecebimentoBar = dataRecebimentoBar;
    }

    public LocalTime getHoraRecebimentoBar() {
        return horaRecebimentoBar;
    }

    public void setHoraRecebimentoBar(LocalTime horaRecebimentoBar) {
        this.horaRecebimentoBar = horaRecebimentoBar;
    }

    public LocalDate getDataEntregaBar() {
        return dataEntregaBar;
    }

    public void setDataEntregaBar(LocalDate dataEntregaBar) {
        this.dataEntregaBar = dataEntregaBar;
    }

    public LocalTime getHoraEntregaBar() {
        return horaEntregaBar;
    }

    public void setHoraEntregaBar(LocalTime horaEntregaBar) {
        this.horaEntregaBar = horaEntregaBar;
    }

    public Usuario getQuemRemoveu() {
        return quemRemoveu;
    }

    public void setQuemRemoveu(Usuario quemRemoveu) {
        this.quemRemoveu = quemRemoveu;
    }

    public Usuario getQuemLancou() {
        return quemLancou;
    }

    public void setQuemLancou(Usuario quemLancou) {
        this.quemLancou = quemLancou;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
