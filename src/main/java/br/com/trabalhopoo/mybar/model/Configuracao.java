package br.com.trabalhopoo.mybar.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.trabalhopoo.mybar.enums.ModoOperacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "configuracao")
public class Configuracao {
    @Id
    @NotNull
    private Long id = 1L;
    private BigDecimal valorIngressoMasc;
    private BigDecimal valorIngressoFemin;
    private LocalDate data;
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    private ModoOperacao modoOperacao;

}
