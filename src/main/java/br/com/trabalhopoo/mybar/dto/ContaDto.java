package br.com.trabalhopoo.mybar.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.enums.Sexo;

public class ContaDto {
    private Integer numeroConta;
    private String codigoGarcom;
    private String senha;
    private String cpfCliente;
    private String nomeCliente;
    private String celularCliente;
    private Sexo sexoCliente;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate data; 
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hora;
    public void setNumeroConta(Integer numeroConta) { this.numeroConta = numeroConta; }
    public void setCodigoGarcom(String codigoGarcom) { this.codigoGarcom = codigoGarcom; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setCelularCliente(String celularCliente) { this.celularCliente = celularCliente; }
    public void setSexoCliente(Sexo sexoCliente) { this.sexoCliente = sexoCliente; }
    public void setData(LocalDate data){this.data = data;}
    public void setHora(LocalTime hora){this.hora = hora;}
    public LocalDate getData()
    {
        return data;
    }
    public LocalTime getHora()
    {
        return hora;
    }
    public Integer getNumeroConta()
    {
        return numeroConta;
    }
    public String  getCodigoGarcom()
    {
        return codigoGarcom;
    }
    public String getSenha()
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
    public static ContaDto fromEntity(Conta conta) {
        ContaDto dto = new ContaDto();

        dto.setCpfCliente(conta.getCliente().getCpf());
        dto.setNomeCliente(conta.getCliente().getNome());
        dto.setCelularCliente(conta.getCliente().getCelular());
        dto.setSexoCliente(conta.getCliente().getSexo());
        dto.setNumeroConta(conta.getNumero());
        dto.setData(conta.getDataAbertura());
        dto.setHora(conta.getHoraAbertura());
        if(conta.getGarconAbertura()!= null)
        {
            dto.setCodigoGarcom(conta.getGarconAbertura().getCodigo());
            dto.setCodigoGarcom(conta.getGarconAbertura().getSenha());

        }

        return dto;
    }
}
