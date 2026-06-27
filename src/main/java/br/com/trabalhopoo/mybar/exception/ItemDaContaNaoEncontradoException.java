package br.com.trabalhopoo.mybar.exception;

public class ItemDaContaNaoEncontradoException extends RuntimeException{
    public ItemDaContaNaoEncontradoException(String mensagem)
    {
        super(mensagem);
    }
}
