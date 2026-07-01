package br.com.trabalhopoo.mybar.controller;

import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.model.enums.StatusItem;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {

    private ItemDaContaRepository itemDaContaRepository;

    public CozinhaController(ItemDaContaRepository itemContaDao) {
        this.itemDaContaRepository = itemContaDao;
    }

    @GetMapping("/pedidos")
    public List<ItemDaConta> listarPedidosCozinha() {
        return itemDaContaRepository
                .findByItemCardapio_TipoItem_CozinhaTrueAndStatusInOrderByDataRecebimentoCozinhaAsc(
                        Arrays.asList(StatusItem.SOLICITADO, StatusItem.RECEBIDO, StatusItem.EM_PREPARACAO)
                );
    }

    @PutMapping("/receber/{id}")
    public ItemDaConta receberPedido(@PathVariable Long id) {
        ItemDaConta item = buscarItemConta(id);
        if (item.getStatus() != StatusItem.SOLICITADO) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Somente pedidos SOLICITADO podem ser recebidos");
        }
        item.setStatus(StatusItem.RECEBIDO);
        return itemDaContaRepository.save(item);
    }

    @PutMapping("/preparar/{id}")
    public ItemDaConta prepararPedido(@PathVariable long id) {
        ItemDaConta item = buscarItemConta(id);
        if (item.getStatus() != StatusItem.RECEBIDO) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Somente pedidos RECEBIDO podem entrar em preparacao");
        }
        item.setStatus(StatusItem.EM_PREPARACAO);
        return itemDaContaRepository.save(item);
    }

    @PutMapping("/entregar/{id}")
    public ItemDaConta entregarPedido(@PathVariable Long id) {
        ItemDaConta item = buscarItemConta(id);
        if (item.getStatus() != StatusItem.EM_PREPARACAO) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Somente pedidos EM_PREPARACAO podem ser entregues");
        }
        item.setStatus(StatusItem.ENTREGUE);
        return itemDaContaRepository.save(item);
    }

    private ItemDaConta buscarItemConta(Long id) {
        return itemDaContaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pedido nao encontrado"));
    }
}
