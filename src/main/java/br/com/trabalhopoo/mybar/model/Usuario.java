package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import br.com.trabalhopoo.mybar.enums.TipoDeUsuario;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senha;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipo;

    @OneToOne 
    private ItemDaConta quemRemoveu;

    @OneToMany(mappedBy = "quemLancou", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDaConta> quemLancou;

    @OneToMany(mappedBy = "quemExcluiuPg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> quemExcluiuPg;

    @OneToOne
    private Pagamento quemLancouPg;

    @OneToMany(mappedBy = "garconAbertura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Conta> garconAbertura;

    public Usuario() {
    }

    public Usuario(Long id, String senha, String nome, String email, TipoDeUsuario tipo, ItemDaConta quemRemoveu, List<ItemDaConta> quemLancou, List<Pagamento> quemExcluiuPg, Pagamento quemLancouPg, List<Conta> garconAbertura) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.quemRemoveu = quemRemoveu;
        this.quemLancou = quemLancou;
        this.quemExcluiuPg = quemExcluiuPg;
        this.quemLancouPg = quemLancouPg;
        this.garconAbertura = garconAbertura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDeUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeUsuario tipo) {
        this.tipo = tipo;
    }

    public ItemDaConta getQuemRemoveu() {
        return quemRemoveu;
    }

    public void setQuemRemoveu(ItemDaConta quemRemoveu) {
        this.quemRemoveu = quemRemoveu;
    }

    public List<ItemDaConta> getQuemLancou() {
        return quemLancou;
    }

    public void setQuemLancou(List<ItemDaConta> quemLancou) {
        this.quemLancou = quemLancou;
    }

    public List<Pagamento> getQuemExcluiuPg() {
        return quemExcluiuPg;
    }

    public void setQuemExcluiuPg(List<Pagamento> quemExcluiuPg) {
        this.quemExcluiuPg = quemExcluiuPg;
    }

    public Pagamento getQuemLancouPg() {
        return quemLancouPg;
    }

    public void setQuemLancouPg(Pagamento quemLancouPg) {
        this.quemLancouPg = quemLancouPg;
    }

    public List<Conta> getGarconAbertura() {
        return garconAbertura;
    }

    public void setGarconAbertura(List<Conta> garconAbertura) {
        this.garconAbertura = garconAbertura;
    }
}
