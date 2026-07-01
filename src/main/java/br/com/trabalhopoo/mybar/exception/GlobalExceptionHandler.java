package br.com.trabalhopoo.mybar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trabalhopoo.mybar.model.TipoItem;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContaJaAbertaException.class)
    public String tratarContaJaAberta(ContaJaAbertaException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas/registrar";
    }
    @ExceptionHandler(ContaJaFechadaException.class)
    public String tratarContaJaFechada(ContaJaFechadaException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas";
    }
    @ExceptionHandler(ContaNaoEncontradaException.class)
    public String tratarContaNaoEncontrada(ContaNaoEncontradaException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas";

    }
    @ExceptionHandler(ContaFaltandoPagamentoException.class)
    public String tratarContaFaltandoPagamento(ContaFaltandoPagamentoException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas/"+ex.getId()+"/fechar";

    }

    @ExceptionHandler(ContaComNumeroJaExistenteException.class)
    public String tratarContaComNumeroJaExistenteException(ContaComNumeroJaExistenteException ex, RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas/"+ex.getId()+"/editar";

    }
   @ExceptionHandler(ItemCardapioNaoEncontradoException.class)
    public String tratarItemCardapioNaoEncontrado(ItemCardapioNaoEncontradoException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/itens-cardapio";

    }
    @ExceptionHandler(ItemCardapioNaoEncontrado2Exception.class)
    public String tratarItemCardapioNaoEncontrado(ItemCardapioNaoEncontrado2Exception ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas/"+ex.getId()+"/itens";

    }
    @ExceptionHandler(ItemCardapioJaRegistradoException.class)
    public String tratarItemCardapioJaRegistrado(ItemCardapioJaRegistradoException ex, RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/itens-cardapio/registrar";
    }
    @ExceptionHandler(ContaComPedidosException.class)
    public String tratarContaComPedidos(ContaComPedidosException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/contas";

    }

    @ExceptionHandler(TipoItemNaoEncontradoException.class)
    public String tratarTipoItemNaoEncontrado(TipoItemNaoEncontradoException ex, RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/tiposItem";

    }
    @ExceptionHandler(TipoItemJaRegistradoException.class)
    public String tratarTipoItemJaRegistrado(TipoItemJaRegistradoException ex,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("mensagem", ex.getMessage());
        return "redirect:/tiposItem/registrar";
    }



}
