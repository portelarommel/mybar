package br.com.trabalhopoo.mybar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import br.com.trabalhopoo.mybar.model.enums.Status;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true, length = 4)
    private Integer numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "data_abertura", nullable = false)
    private LocalDate dataAbertura;

    @Column(name = "hora_abertura", nullable = false)
    private LocalTime horaAbertura;

    @ManyToOne
    @JoinColumn(name = "id_garcom_abertura", nullable = true)
    private Usuario garconAbertura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @OneToMany (mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ItemDaConta> itensDaConta = new ArrayList<>();

    public void adicionarItem(ItemDaConta item) {
        item.setConta(this);
        this.itensDaConta.add(item);
    }

    public Conta() {
    }

    public Conta(Integer numero, Status status, LocalDate dataAbertura, LocalTime horaAbertura, Usuario garconAbertura, Cliente cliente) {
        this.numero = numero;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.garconAbertura = garconAbertura;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Usuario getGarconAbertura() {
        return garconAbertura;
    }

    public void setGarconAbertura(Usuario garconAbertura) {
        this.garconAbertura = garconAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<ItemDaConta> getItensDaConta() {
        return itensDaConta;
    }

    public void setItensDaConta(List<ItemDaConta> itensDaConta) {
        this.itensDaConta = itensDaConta;
    }
}
