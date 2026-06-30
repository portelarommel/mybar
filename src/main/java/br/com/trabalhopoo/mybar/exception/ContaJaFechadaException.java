package br.com.trabalhopoo.mybar.exception;

public class ContaJaFechadaException extends RuntimeException  {
    private Long id;
    public Long getId()
    {
        return id;
    }
    public ContaJaFechadaException(String mensagem, Long id)
    {
        super(mensagem);
        this.id =id;
    }
    
}
