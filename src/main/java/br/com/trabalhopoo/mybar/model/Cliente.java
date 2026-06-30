package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import br.com.trabalhopoo.mybar.model.enums.Sexo;

@Entity
@Table(name = "cliente")
public class Cliente {

    @NotBlank
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Id
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "celular", length = 15, nullable = false)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
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
