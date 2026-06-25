package br.com.trabalhopoo.mybar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.trabalhopoo.mybar.model.TipoItem;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContaJaAbertaException.class)
    public ResponseEntity<ErroResponse> tratarContaJaAberta(ContaJaAbertaException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(ex.getMessage()));
    }
    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> tratarContaNaoEncontrada(ContaNaoEncontradaException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponse(ex.getMessage()));

    }
   @ExceptionHandler(ItemCardapioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarItemCardapioNaoEncontrado(ItemCardapioNaoEncontradoException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponse(ex.getMessage()));

    }
    @ExceptionHandler(ItemCardapioJaRegistradoException.class)
    public ResponseEntity<ErroResponse> tratarItemCardapioJaRegistrado(ItemCardapioJaRegistradoException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(ex.getMessage()));
    }
    @ExceptionHandler(ContaComPedidosException.class)
    public ResponseEntity<ErroResponse> tratarContaComPedidos(ContaComPedidosException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(ex.getMessage()));

    }

    @ExceptionHandler(TipoItemNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarTipoItemNaoEncontrado(TipoItemNaoEncontradoException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponse(ex.getMessage()));

    }
    @ExceptionHandler(TipoItemJaRegistradoException.class)
    public ResponseEntity<ErroResponse> tratarTipoItemJaRegistrado(TipoItemJaRegistradoException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(ex.getMessage()));
    }



}
