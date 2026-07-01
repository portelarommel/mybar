package br.com.trabalhopoo.mybar.exception;

public class ItemCardapioNaoEncontrado2Exception extends RuntimeException{
    private Long id;
    public Long getId()
    {
        return id;

    }
    public ItemCardapioNaoEncontrado2Exception(String mensagem,Long id)
    {
        super(mensagem);
    }
    
}
