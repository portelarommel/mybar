package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    private int numero;
    private String status;
    //private data abertura
    //private hora abertura

}
