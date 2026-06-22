package br.com.trabalhopoo.mybar.exception;

public class TipoItemNaoEncontradoException extends RuntimeException {
    public TipoItemNaoEncontradoException(String mensagem)
    {
        super(mensagem);
    }

}
