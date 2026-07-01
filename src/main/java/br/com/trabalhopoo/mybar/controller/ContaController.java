package br.com.trabalhopoo.mybar.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhopoo.mybar.model.enums.Status;
import br.com.trabalhopoo.mybar.dto.ContaDto;
import br.com.trabalhopoo.mybar.dto.ItemDaContaDto;
import br.com.trabalhopoo.mybar.dto.PagamentoDto;
import br.com.trabalhopoo.mybar.exception.ContaJaFechadaException;
import br.com.trabalhopoo.mybar.model.Conta;
import br.com.trabalhopoo.mybar.model.ItemDaConta;
import br.com.trabalhopoo.mybar.service.ContaService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    /*@GetMapping
    public ResponseEntity<List<Conta>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
    }*/

    @GetMapping
    public String pesquisarConta(@RequestParam(required = false) Integer numeroConta,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String nomeCliente,
            @RequestParam(required = false) Boolean aberta,
            Model model){
        Status status = null;
        if(aberta != null)
        {   
            status = aberta? Status.ABERTA : Status.FECHADA;

        }
        List<Conta> encontrada = contaService.pesquisarContaPorFiltros(numeroConta, cpf, nomeCliente, status);
        model.addAttribute("contas",encontrada);
        return "conta/gestaoDeContas";
    }

    @GetMapping("/{id}/editar")
    public String carregarPaginaEdicao(@PathVariable Long id, Model model)
    {
        Conta conta = contaService.pesquisarConta(id);
        ContaDto contaDto = ContaDto.fromEntity(conta);
        model.addAttribute("contaDto",contaDto);
        return "conta/edicaoDeConta";
    }
    @PostMapping("/{id}/editar")
    public String alterarConta(@PathVariable Long id, @ModelAttribute ContaDto contaDto, Model model)
    {
        contaService.alterarConta(id, contaDto);
        return "redirect:/contas";
    }
    @GetMapping("/registrar")
    public String carregarPaginaRegistro(Model model)
    {
        model.addAttribute("contaDto", new ContaDto());
        return "conta/registroDeConta";
    } 
    @PostMapping("/registrar")
    public String abrirConta(@ModelAttribute("contaDto") ContaDto contaDto)
    {
        contaService.abrirConta(contaDto);
        return "redirect:/contas";
    }

    @GetMapping("/{id}/visualizar")
    public String visualizarConta(@PathVariable Long id, Model model)
    {
        Conta conta = contaService.pesquisarConta(id);
        ContaDto contaDto =  ContaDto.fromEntity(conta);
        model.addAttribute("contaDto",contaDto);
        return "conta/visualizacaoDeConta";
    }

    @GetMapping("/{id}/fechar")
    public String CarregarPaginaFecharConta(@PathVariable Long id, Model model)
    {
        Conta conta = contaService.pesquisarConta(id);
        ContaDto contaDto =  ContaDto.fromEntity(conta);
        BigDecimal gorjeta =contaService.calcularGorjeta(id);
        BigDecimal ingresso = contaService.calcularValorIngresso(id);
        List<ItemDaConta> itensDaConta =  contaService.ListarItensFechamento(id);
        List<ItemDaContaDto> itensDaContaDto = itensDaConta.stream()
        .map((ItemDaConta item) -> {
        return new ItemDaContaDto(
            item.getId(),
            item.getQuantidade(),
            item.getCodigo(),
            item.getItemCardapio().getDescricao(),
            item.getItemCardapio().getValor()

        );}).collect(Collectors.toList());
        model.addAttribute("contaDto",contaDto);
        model.addAttribute("itensDaConta",itensDaContaDto);
        model.addAttribute("totalConta",contaService.CalcularTotalConta(id,ingresso,gorjeta));
        model.addAttribute("totalPago",contaService.CalcularTotalPago(id));
        model.addAttribute("pagamentos",contaService.ListarPagamentos(id));
        model.addAttribute("valorGorjeta", gorjeta);
        model.addAttribute("valorIngresso",ingresso);
        model.addAttribute("id", id);
        return "conta/fechamentoDeConta";
    }
    @PostMapping("/{id}/fechar")
    public String AdicionarPagamento(@PathVariable Long id, @ModelAttribute("pagamentoDto") PagamentoDto pagamentoDto, Model model)
    { 
        contaService.AdicionarPagamento(id, pagamentoDto);
        return "redirect:/contas/"+id+"/fechar";
    }
    @PostMapping("/{id}/{idPagamento}/excluir-pagamento")
    public String ExcluirPagamento(@PathVariable Long id,@PathVariable Long idPagamento,@RequestParam String usuarioConfirmacao,
                               @RequestParam String senhaConfirmacao)
    {
        contaService.ExcluirPagamento(id,idPagamento);
        return "redirect:/contas/"+id+"/fechar";
    }
    @PostMapping("/{id}/concluir")
    public String FecharConta(@PathVariable Long id, Model model)
    {
        BigDecimal gorjeta =contaService.calcularGorjeta(id);
        BigDecimal ingresso = contaService.calcularValorIngresso(id);
        BigDecimal totalConta = contaService.CalcularTotalConta(id, ingresso, gorjeta);
        BigDecimal totalPago = contaService.CalcularTotalPago(id);
        contaService.FecharConta (id,totalConta,totalPago,
        ingresso,
        gorjeta);
        return "redirect:/contas";
    }

    @GetMapping("/{id}/excluir")
    public String excluirConta(@PathVariable Long id)
    {
        contaService.excluirConta(id);
        return "redirect:/contas";
    }
}
