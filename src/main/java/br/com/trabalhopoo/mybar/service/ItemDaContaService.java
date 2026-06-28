package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemDaContaService {

    private final ContaService contaService;
    private final ContaRepository contaRepository;
    private final ItemDaContaRepository itemDaContaRepository;

    public ItemDaContaService(ContaService contaService, ContaRepository contaRepository, ItemDaContaRepository itemDaContaRepository) {
        this.contaService = contaService;
        this.contaRepository = contaRepository;
        this.itemDaContaRepository = itemDaContaRepository;
    }

    public ItemDaConta registrarItemConta(Long contaId, ItemDaConta itemDaConta) {
        Conta conta = contaService.pesquisarConta(contaId);
        conta.adicionarItem(itemDaConta);
        contaRepository.save(conta);
        return itemDaConta;
    }

    public List<ItemDaConta> listarPorConta(Long id) {
        Conta conta = contaService.pesquisarConta(id);
        return conta.getItensDaConta();
    }

    public void excluirItem(Long contaId, Long itemId) {
        Conta conta = contaService.pesquisarConta(contaId);

        ItemDaConta item = conta.getItensDaConta().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado na conta."));

        item.setAtivo(false);
        itemDaContaRepository.save(item);
    }
}
