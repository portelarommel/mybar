package br.com.trabalhopoo.mybar.dto;

import java.time.LocalDateTime;

import br.com.trabalhopoo.mybar.model.enums.StatusItem;

public class ItemDaContaEntregaDto {
    private Long id;
    private Integer codigoConta;
    private String tipo;
    private String descricao;
    private LocalDateTime dataHora;
    private StatusItem status;
    public ItemDaContaEntregaDto(Long id, Integer codigoConta, String tipo, String descricao, LocalDateTime dataHora, StatusItem status) {
        this.id = id;
        this.codigoConta = codigoConta;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.status = status;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(Integer codigoConta) {
        this.codigoConta = codigoConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }
}
