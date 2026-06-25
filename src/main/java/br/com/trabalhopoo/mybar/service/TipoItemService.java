package br.com.trabalhopoo.mybar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.exception.TipoItemJaRegistradoException;
import br.com.trabalhopoo.mybar.exception.TipoItemNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.repository.TipoItemRepository;
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
    public TipoItem buscarTipoItem(Integer codigo)
    {
        TipoItem encontrado = (TipoItem)tipoItemRepository.findById(codigo).orElseThrow(() -> new TipoItemNaoEncontradoException("Não foi encontrado esse tipo de Item!"));
        return encontrado;
    }
    public TipoItem registrarTipoItem(TipoItem tipoItem)
    {
        if(tipoItemRepository.existsById(tipoItem.getCodigo()))
        {
            throw new TipoItemJaRegistradoException("Já existe um item no cardápio com esse código!");
        }
        TipoItem nova = tipoItemRepository.save(tipoItem);
        return nova;


    }
    public TipoItem editarTipoItem(TipoItem tipoItem)
    {

        TipoItem editado = tipoItemRepository.save(tipoItem);
        return editado;

    }
    public Boolean deletarTipoItem(Integer codigo)
    {
        TipoItem buscar = buscarTipoItem(codigo);
        if (!buscar.getItensCardapio().isEmpty()) {
            buscar.setAtivo(false);
            return true;

        }
        tipoItemRepository.deleteById(codigo);
        return true;
    }

}
