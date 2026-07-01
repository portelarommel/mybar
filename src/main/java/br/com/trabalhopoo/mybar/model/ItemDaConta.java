package br.com.trabalhopoo.mybar.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.model.enums.Sentenca;
import br.com.trabalhopoo.mybar.model.enums.StatusItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_da_conta")
public class ItemDaConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "codigo",length = 4, nullable =false)
    private Integer codigo;

    private BigDecimal valor; // nao tem no pdf mas vou analisar dps

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_solicitacao")
    private LocalDate dataSolicitacao;

    @Column(name = "hora_solicitacao")
    private LocalTime horaSolicitacao;

    @Column(name = "data_recebimento_cozinha")
    private LocalDate dataRecebimentoCozinha;

    @Column(name = "hora_recebimento_cozinha")
    private LocalTime horaRecebimentoCozinha;

    @Column(name = "data_entrega_cozinha")
    private LocalDate dataEntregaCozinha;

    @Column(name = "hora_entrega_cozinha")
    private LocalTime horaEntregaCozinha;

    @Column(name = "data_recebimento_bar")
    private LocalDate dataRecebimentoBar;

    @Column(name = "hora_recebimento_bar")
    private LocalTime horaRecebimentoBar;

    @Column(name = "data_entrega_bar")
    private LocalDate dataEntregaBar;

    @Column(name = "hora_entrega_bar")
    private LocalTime horaEntregaBar;

    @ManyToOne
    @JoinColumn(name = "id_garcom_remocao")
    private Usuario quemRemoveu;

    @ManyToOne
    @JoinColumn(name = "id_garcom_lancamento")
    private Usuario quemLancou;

    @ManyToOne
    @JoinColumn(name = "item_cardapio_id", nullable = true)
    private ItemCardapio itemCardapio;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusItem status;

    public ItemDaConta() {
    }


    public ItemDaConta(Long id, BigDecimal valor, int quantidade, LocalDate dataSolicitacao, LocalTime horaSolicitacao, LocalDate dataRecebimentoCozinha, LocalTime horaRecebimentoCozinha, LocalDate dataEntregaCozinha, LocalTime horaEntregaCozinha, LocalDate dataRecebimentoBar, LocalTime horaRecebimentoBar, LocalDate dataEntregaBar, LocalTime horaEntregaBar, Usuario quemRemoveu, Usuario quemLancou, ItemCardapio itemCardapio, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public StatusItem getStatus() {
        if (getItemCardapio() == null || getItemCardapio().getTipoItem() == null) {
            return null;
        }

        if (getItemCardapio().getTipoItem().getCozinha() == Sentenca.SIM) {
            if (this.getDataEntregaCozinha() != null) return StatusItem.ENTREGUE;
            if (this.getDataRecebimentoCozinha() != null) return StatusItem.RECEBIDO;
            return StatusItem.SOLICITADO;
        } else {
            if (this.getDataEntregaBar() != null) return StatusItem.ENTREGUE;
            if (this.getDataRecebimentoBar() != null) return StatusItem.RECEBIDO;
            return StatusItem.SOLICITADO;
        }
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

    public void setStatus(StatusItem status) {
        this.status = status;
    }
}
