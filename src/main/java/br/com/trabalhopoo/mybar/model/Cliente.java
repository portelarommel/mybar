package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;

import  br.com.trabalhopoo.mybar.enums.Sexo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @NotBlank
    private String nome;
    @Id
    @Column(unique = true)
    @NotBlank @CPF
    private String cpf;

    private String celular;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @OneToMany
    private Conta conta;

}
