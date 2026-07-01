package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.repository.ItemCardapioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCardapioService {


    private final ItemCardapioRepository itemCardapioRepository;

    public ItemCardapioService(ItemCardapioRepository itemCardapioRepository) {
        this.itemCardapioRepository = itemCardapioRepository;
    }

    public List<ItemCardapio> listarItensCardapio() {
        return itemCardapioRepository.findByAtivoTrue();
    }

    public ItemCardapio buscarItemCardapio(Long id) {
        return itemCardapioRepository.findById(id)
                .orElseThrow(() ->
                        new ItemCardapioNaoEncontradoException(
                                "Não foi encontrado esse item no cardápio!"));
    }
    public List<ItemCardapio> buscarItemCardapioPorFiltros(Long codigo, String descricao, Long tipoItemId)
    {
        return itemCardapioRepository.buscarComFiltrosDeTela(codigo, descricao, tipoItemId);
    }
    public ItemCardapio registrarItemCardapio(ItemCardapio itemCardapio) { 
        
        return itemCardapioRepository.save(itemCardapio);
    }

    public ItemCardapio editarItemCardapio(ItemCardapio itemCardapio) {

        ItemCardapio existente = buscarItemCardapio(itemCardapio.getId());

        existente.setDescricao(itemCardapio.getDescricao());
        existente.setValor(itemCardapio.getValor());
        existente.setAtivo(itemCardapio.getAtivo());
        existente.setTipoItem(itemCardapio.getTipoItem());

        return itemCardapioRepository.save(existente);
    }

    public void deletarItemCardapio(Long id) {

        ItemCardapio item = buscarItemCardapio(id);

        if (!item.getItensDaConta().isEmpty()) {
            item.setAtivo(false);
            itemCardapioRepository.save(item);
            return;
        }

        itemCardapioRepository.delete(item);
    }
}
