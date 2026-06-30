package br.com.trabalhopoo.mybar.dto;

import br.com.trabalhopoo.mybar.model.enums.Sexo;

public class ContaDto {
    private Integer numeroConta;
    private Integer codigoGarcom;
    private Integer senha;
    private String cpfCliente;
    private String nomeCliente;
    private String celularCliente;
    private Sexo sexoCliente;
    public void setNumeroConta(Integer numeroConta) { this.numeroConta = numeroConta; }
    public void setCodigoGarcom(Integer codigoGarcom) { this.codigoGarcom = codigoGarcom; }
    public void setSenha(Integer senha) { this.senha = senha; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setCelularCliente(String celularCliente) { this.celularCliente = celularCliente; }
    public void setSexoCliente(Sexo sexoCliente) { this.sexoCliente = sexoCliente; }
    public Integer getNumeroConta()
    {
        return numeroConta;
    }
    public Integer  getCodigoGarcom()
    {
        return codigoGarcom;
    }
    public Integer getSenha()
    {
        return senha;
    }
    public String getCpfCliente()
    {
        return cpfCliente;
    }
    public String getCelularCliente()
    {
        return celularCliente;
    }
    public String getNomeCliente()
    {
        return nomeCliente;
    }
    public Sexo getSexoCliente()
    {
        return sexoCliente;
    }
}
