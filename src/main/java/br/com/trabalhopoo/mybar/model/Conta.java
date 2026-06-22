package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @Column(length = 4, nullable = false)
    @Pattern(regexp = "\\d{4}", message = "Deve conter exatamente 4 dígitos")
    private String numero;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dataAbertura;
    private LocalTime horaAbertura;
    @ManyToOne
    private Usuario garconAbertura;
    @OneToMany
    private List<Pagamento> pagamento = new ArrayList();
    @ManyToOne
    private Cliente cliente;
    @OneToMany (mappedBy = "conta", cascade = CascadeType.ALL)
    private List<ItemDaConta> itensDaConta = new ArrayList();

    public void adicionarItem(ItemDaConta item) {
            itensDaConta.add(item);
             item.setConta(this);
            }


}
