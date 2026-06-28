package br.com.trabalhopoo.mybar.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhopoo.mybar.model.enums.StatusItem;
import br.com.trabalhopoo.mybar.exception.ItemDaContaNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import jakarta.transaction.Transactional;

@Service
public class ControleEntregaService {
    @Autowired
    public ItemDaContaRepository itemDaContaRepository;
    
    public List<ItemDaConta> buscarItemDaConta(Integer numeroConta,  String nomeCliente)
    {
        List<ItemDaConta> itens = itemDaContaRepository.buscarParaControleEntregas(numeroConta, nomeCliente);
        Map<StatusItem, Integer> pesoStatus = Map.of(
            StatusItem.SOLICITADO, 1,
            StatusItem.RECEBIDO, 2,
            StatusItem.ENTREGUE, 3
        );
        itens.sort(Comparator.comparingInt(item -> pesoStatus.getOrDefault(item.getStatus(), 4)));
        return itens;

    }
    @Transactional
    public ItemDaConta receberNoBar(Long id)
    {
        ItemDaConta item = itemDaContaRepository.findById(id)
        .orElseThrow(() -> new ItemDaContaNaoEncontradoException("Item não encontrado"));
        item.setDataRecebimentoBar(LocalDate.now());
        item.setHoraRecebimentoBar(LocalTime.now());

        return itemDaContaRepository.save(item);
    }
    @Transactional
    public ItemDaConta registrarEntregaFinalBar(Long id)
    {
        ItemDaConta item = itemDaContaRepository.findById(id)
        .orElseThrow(() -> new ItemDaContaNaoEncontradoException("Item não encontrado"));
        item.setDataEntregaBar(LocalDate.now());
        item.setHoraEntregaBar(LocalTime.now());

        return itemDaContaRepository.save(item);
    }

}
