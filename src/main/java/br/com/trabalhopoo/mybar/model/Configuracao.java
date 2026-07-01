package br.com.trabalhopoo.mybar.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.model.enums.ModoOperacao;
import jakarta.persistence.*;

@Entity
@Table(name = "configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_ingresso_masc", nullable = false)
    private BigDecimal valorIngressoMasc;

    @Column(name = "valor_ingresso_fem", nullable = false)
    private BigDecimal valorIngressoFemin;
   
    @Column(name = "data")
    private LocalDate data;

    @Column(name = "hora")
    private LocalTime hora;

    private LocalDate dataFechamento;
    private LocalTime horaFechamento;
    public LocalDate getDataFechamento() {
    return dataFechamento;
}

public void setDataFechamento(LocalDate dataFechamento) {
    this.dataFechamento = dataFechamento;
}

public LocalTime getHoraFechamento() {
    return horaFechamento;
}

public void setHoraFechamento(LocalTime horaFechamento) {
    this.horaFechamento = horaFechamento;
}


    @Enumerated(EnumType.STRING)
    @Column(name = "modo_operacao", nullable = false)
    private ModoOperacao modoOperacao;

    public Configuracao() {
    }

    public Configuracao(Long id, BigDecimal valorIngressoMasc, BigDecimal valorIngressoFemin, LocalDate data, LocalTime hora, ModoOperacao modoOperacao) {
        this.id = id;
        this.valorIngressoMasc = valorIngressoMasc;
        this.valorIngressoFemin = valorIngressoFemin;
        this.data = data;
        this.hora = hora;
        this.modoOperacao = modoOperacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorIngressoMasc() {
        return valorIngressoMasc;
    }

    public void setValorIngressoMasc(BigDecimal valorIngressoMasc) {
        this.valorIngressoMasc = valorIngressoMasc;
    }

    public BigDecimal getValorIngressoFemin() {
        return valorIngressoFemin;
    }

    public void setValorIngressoFemin(BigDecimal valorIngressoFemin) {
        this.valorIngressoFemin = valorIngressoFemin;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ModoOperacao getModoOperacao() {
        return modoOperacao;
    }

    public void setModoOperacao(ModoOperacao modoOperacao) {
        this.modoOperacao = modoOperacao;
    }
}
