package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import br.com.trabalhopoo.mybar.model.enums.TipoDeUsuario;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoDeUsuario tipo;

    @OneToMany(mappedBy = "quemRemoveu")
    @JsonIgnore
    private List<ItemDaConta> quemRemoveu;

    @OneToMany(mappedBy = "quemLancou")
    @JsonIgnore
    private List<ItemDaConta> quemLancou;

    @OneToMany(mappedBy = "quemExcluiuPg")
    private List<Pagamento> quemExcluiuPg;

    @OneToMany(mappedBy = "quemLancouPg")
    private List<Pagamento> quemLancouPg;

    @OneToMany(mappedBy = "garconAbertura")
    @JsonIgnore
    private List<Conta> garconAbertura;

    public Usuario() {
    }

    public Usuario(Long id, String senha, String codigo, String nome, String email, TipoDeUsuario tipo, List<ItemDaConta> quemRemoveu, List<ItemDaConta> quemLancou, List<Pagamento> quemExcluiuPg, List<Pagamento> quemLancouPg, List<Conta> garconAbertura) {
        this.id = id;
        this.senha = senha;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public List<ItemDaConta> getQuemRemoveu() {
        return quemRemoveu;
    }

    public void setQuemRemoveu(List<ItemDaConta> quemRemoveu) {
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

    public List<Pagamento> getQuemLancouPg() {
        return quemLancouPg;
    }

    public void setQuemLancouPg(List<Pagamento> quemLancouPg) {
        this.quemLancouPg = quemLancouPg;
    }

    public List<Conta> getGarconAbertura() {
        return garconAbertura;
    }

    public void setGarconAbertura(List<Conta> garconAbertura) {
        this.garconAbertura = garconAbertura;
    }
}
