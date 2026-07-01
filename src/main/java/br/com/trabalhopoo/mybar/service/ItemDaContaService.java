package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.dto.ItemDaContaDto;
import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontrado2Exception;
import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.repository.ContaRepository;
import br.com.trabalhopoo.mybar.repository.ItemCardapioRepository;
import br.com.trabalhopoo.mybar.repository.ItemDaContaRepository;
import jakarta.persistence.EntityNotFoundException;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemDaContaService {

    private final ContaService contaService;
    private final ContaRepository contaRepository;
    private final ItemDaContaRepository itemDaContaRepository;
    private final ItemCardapioRepository itemCardapioRepository;

    public ItemDaContaService(ContaService contaService,ContaRepository contaRepository, ItemDaContaRepository itemDaContaRepository,ItemCardapioRepository itemCardapioRepository) {
        this.contaService = contaService;
        this.contaRepository = contaRepository;
        this.itemDaContaRepository = itemDaContaRepository;
        this.itemCardapioRepository = itemCardapioRepository;
    }

    public ItemDaConta registrarItemConta(Long contaId, ItemDaContaDto itemDaContaDto) {
        ItemCardapio itemCardapio = itemCardapioRepository.findByCodigo(itemDaContaDto.getCodigo()).orElseThrow(() -> new ItemCardapioNaoEncontrado2Exception("Item de Cardapio não encontrado",contaId));;

        ItemDaConta itemDaConta = new ItemDaConta();
        itemDaConta.setItemCardapio(itemCardapio);
        itemDaConta.setDataSolicitacao(LocalDate.now());
        itemDaConta.setHoraSolicitacao(LocalTime.now());
        itemDaConta.setQuantidade(itemDaContaDto.getQuantidade());
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
