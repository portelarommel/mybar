package br.com.trabalhopoo.mybar.dto;

import java.math.BigDecimal;

import br.com.trabalhopoo.mybar.models.enums.FormaDePagamento;

public class PagamentoDto {
    private BigDecimal valor;
    private String forma;
    private String codigoGarcom;
    private String senha;
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
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

}
