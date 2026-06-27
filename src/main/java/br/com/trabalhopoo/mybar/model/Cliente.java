package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import  br.com.trabalhopoo.mybar.enums.Sexo;

@Entity
@Table(name = "cliente")
public class Cliente {
    @NotBlank
    private String nome;

    @Id
    @NotBlank
    //@CPF
    private String cpf;

    private String celular;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conta> contas;

    public Cliente() {}

    public Cliente(String nome, String cpf, String celular, Sexo sexo, List<Conta> contas) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.sexo = sexo;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
