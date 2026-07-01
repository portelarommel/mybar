package br.com.trabalhopoo.mybar.dto;

import java.math.BigDecimal;

public class ItemDaContaDto {
    private Integer quantidade;
    private String codigoGarcom;
    private String senha;
    private Integer codigo;


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoGarcom() {
        return codigoGarcom;
    }

    public void setCodigoGarcom(String codigoGarcom) {
        this.codigoGarcom = codigoGarcom;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
