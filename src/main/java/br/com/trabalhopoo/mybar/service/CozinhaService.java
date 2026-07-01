package br.com.trabalhopoo.mybar.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.trabalhopoo.mybar.exception.ItemDaContaNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.model.enums.StatusItem;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import jakarta.transaction.Transactional;

@Service
public class CozinhaService {
    private final ItemDaContaRepository itemDaContaRepository;
    public CozinhaService(ItemDaContaRepository itemDaContaRepository)
    {
        this.itemDaContaRepository =itemDaContaRepository;
    }
    public List<ItemDaConta> buscarComFiltros(Integer numeroConta,StatusItem statusItem)
    {
        return itemDaContaRepository.buscarParaCozinha(numeroConta,statusItem);
        
    }
    @Transactional
    public ItemDaConta entregarPedido(Long id)
    {
        ItemDaConta item = itemDaContaRepository.findById(id)
        .orElseThrow(() -> new ItemDaContaNaoEncontradoException("Item não encontrado"));
        item.setDataEntregaCozinha(LocalDate.now());
        item.setHoraEntregaCozinha(LocalTime.now());
        item.setStatus(StatusItem.ENTREGUE);
        return itemDaContaRepository.save(item);
    }
    @Transactional
    public ItemDaConta receberPedido(Long id)
    {
        ItemDaConta item = itemDaContaRepository.findById(id)
        .orElseThrow(() -> new ItemDaContaNaoEncontradoException("Item não encontrado"));
        item.setDataRecebimentoCozinha(LocalDate.now());
        item.setHoraRecebimentoCozinha(LocalTime.now());
        item.setStatus(StatusItem.RECEBIDO);

        return itemDaContaRepository.save(item);
    }
    
}
