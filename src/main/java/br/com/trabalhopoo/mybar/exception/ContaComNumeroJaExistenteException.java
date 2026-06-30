package br.com.trabalhopoo.mybar.exception;

public class ContaComNumeroJaExistenteException extends RuntimeException {
    private Long id;
    public Long getId()
    {
        return id;
    }
    public ContaComNumeroJaExistenteException(String mensagem,Long id)
    {
        super(mensagem);
        this.id = id;
    }
    
}
