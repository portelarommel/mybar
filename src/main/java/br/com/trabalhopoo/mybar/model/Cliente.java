package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import  br.com.trabalhopoo.mybar.enums.Sexo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    private String nome;
    @Id
    private String cpf;
    private String celular;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;


}
