package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.exception.TipoItemNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.repository.TipoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoItemService {

    private TipoItemRepository tipoItemRepository;

    public TipoItemService (TipoItemRepository tipoItemRepository)
    {
        this.tipoItemRepository= tipoItemRepository;
    }

    public List<TipoItem> listarTiposItem()
    {
        return tipoItemRepository.findByAtivoTrue();
    }

    public TipoItem pesquisarTipoItem(Long id)
    {
        TipoItem encontrado = (TipoItem)tipoItemRepository.findById(id).orElseThrow(() -> new TipoItemNaoEncontradoException("Não foi encontrado esse tipo de Item!"));
        return encontrado;
    }

    public TipoItem registrarTipoItem(TipoItem tipoItem) {
        return tipoItemRepository.save(tipoItem);
    }

    public TipoItem alterarTipoItem(TipoItem tipoItem) {
        TipoItem existente = pesquisarTipoItem(tipoItem.getId());

        existente.setDescricao(tipoItem.getDescricao());
        existente.setAtivo(tipoItem.getAtivo());
        existente.setGorjeta(tipoItem.getGorjeta());
        existente.setCozinha(tipoItem.getCozinha());

        return tipoItemRepository.save(existente);
    }

    public void deletarTipoItem(Long id) {
        TipoItem tipoItem = pesquisarTipoItem(id);

        if (!tipoItem.getItensCardapio().isEmpty()) {
            tipoItem.setAtivo(false);
            tipoItemRepository.save(tipoItem);
            return;
        }
        tipoItemRepository.delete(tipoItem);
    }
}

