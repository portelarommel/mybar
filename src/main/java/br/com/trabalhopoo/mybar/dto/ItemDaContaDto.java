package br.com.trabalhopoo.mybar.dto;

import java.math.BigDecimal;

public class ItemDaContaDto {
    private Integer quantidade;
    private String codigoGarcom;
    private String senha;
    private Integer codigo;
    private Integer codigoCardapio;
    private Long id;
    private BigDecimal valorUnitario;
    private String descricao;


   public ItemDaContaDto(){}
   public ItemDaContaDto(Long id, Integer quantidade, Integer codigo, String descricao,BigDecimal valorUnitario){
    this.id = id;
    this.quantidade =quantidade;
    this.codigo =codigo;
    this.descricao =descricao;
    this.valorUnitario =valorUnitario;
   }
   public void setValorUnitario(BigDecimal valorUnitario)
   {
    this.valorUnitario = valorUnitario;
   }
   public BigDecimal getValorUnitario()
   {
    return valorUnitario;
   }
   public void setId(Long id)
   {
    this.id = id;
   }
   public Long getId()
   {
    return id;
   }
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Integer getCodigoCardapio()
    {
        return codigoCardapio;
    }
    public void setCodigoCardapio(Integer codigoCardapio)
    {
        this.codigoCardapio = codigoCardapio;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
