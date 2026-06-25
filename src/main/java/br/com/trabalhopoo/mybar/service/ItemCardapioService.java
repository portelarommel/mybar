package br.com.trabalhopoo.mybar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.exception.ItemCardapioJaRegistradoException;
import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.repository.ItemCardapioRepository;
@Service
public class ItemCardapioService {
    private ItemCardapioRepository itemCardapioRepository;
    public ItemCardapioService (ItemCardapioRepository itemCardapioRepository)
    {
        this.itemCardapioRepository = itemCardapioRepository;
    }
    public List<ItemCardapio> listarItensCardapio()
    {
        return itemCardapioRepository.findByAtivoTrue();

    }
    public ItemCardapio buscarItemCardapio(Integer codigo)
    {
        ItemCardapio encontrado = (ItemCardapio)itemCardapioRepository.findById(codigo).orElseThrow(() -> new ItemCardapioNaoEncontradoException("Não foi encontado esse item no cardápio!"));
        return encontrado;
    }
    public ItemCardapio registrarItemCardapio(ItemCardapio itemCardapio)
    {
        if(itemCardapioRepository.existsById(itemCardapio.getCodigo()))
        {
            throw new ItemCardapioJaRegistradoException("Já existe um item no cardápio com esse código!");
        }
        ItemCardapio nova = itemCardapioRepository.save(itemCardapio);
        return nova;


    }
    public ItemCardapio editarItemCardapio(ItemCardapio itemCardapio)
    {

        ItemCardapio editado = itemCardapioRepository.save(itemCardapio);
        return editado;

    }
    public Boolean deletarItemCardapio(Integer codigo)
    {
        ItemCardapio buscar = buscarItemCardapio(codigo);
        if (!buscar.getItensDaConta().isEmpty()) {
            buscar.setAtivo(false);
            return true;

        }
        itemCardapioRepository.deleteById(codigo);
        return true;
    }



}
