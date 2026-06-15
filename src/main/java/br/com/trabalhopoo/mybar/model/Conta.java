package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @Min(0)
    @Max(9999)
    private int numero;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dataAbertura;
    private LocalTime horaAbertura;
    @ManyToOne
    private Usuario garconAbertura;
    @OneToMany
    private Pagamento pagamento;
    @ManyToOne
    private Cliente cliente;
    @OneToMany 
    private ItemDaConta itensDaConta;


}
