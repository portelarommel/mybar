package br.com.trabalhopoo.mybar.model;
import jakarta.persistence.*;
import br.com.trabalhopoo.mybar.enums.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.trabalhopoo.mybar.enums.Sentenca;
@Entity
@Table(name="pagamentos")
public class Pagamento {
    private float valor;
    @Enumerated(EnumType.STRING)
    private FormaDePagamento forma;
    @Enumerated(EnumType.STRING)
    private Sentenca ativo;
    @OneToOne 
    private Usuario quemLancouPg;
    @ManyToOne
    private Usuario quemExcluiuPg;

}
