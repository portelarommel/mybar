package br.com.trabalhopoo.mybar.exception;

public class ContaFaltandoPagamentoException extends RuntimeException {
    private Long id;
    public Long getId()
    {
        return id;
    }
    public ContaFaltandoPagamentoException(String mensagem,Long id)
    {
        super(mensagem);
        this.id = id;
        
    }
    
}
