package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.trabalhopoo.mybar.enums.TipoDeUsuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(unique = true)
    private String codigo;
    private String senha;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipo;
    @OneToOne 
    private ItemDaConta quemRemoveu;
    @OneToMany
    private ItemDaConta quemLancou;
    @OneToMany
    private Pagamento quemExcluiuPg;
    @OneToOne
    private Pagamento quemLancouPg;
    @OneToMany
    private Conta garconAbertura;



}
