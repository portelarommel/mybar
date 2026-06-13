package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String status;
    private LocalDate dataAbertura;
    private LocalTime horaAbertura;
    @ManyToOne
    private Usuario garconAbertura;
    @OneToMany
    private Pagamentos pagamento;
    @ManyToOne
    private Cliente cliente;
    @OneToMany 
    private ItensDaConta itensDaConta;


}
