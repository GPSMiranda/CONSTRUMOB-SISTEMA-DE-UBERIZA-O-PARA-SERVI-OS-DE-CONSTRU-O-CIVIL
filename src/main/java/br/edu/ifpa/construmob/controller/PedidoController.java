package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
import br.edu.ifpa.construmob.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/pedidos") public class PedidoController{
 private final PedidoService pedidoService;private final ClienteService clienteService;private final ProfissionalService profissionalService;private final ServicoService servicoService;
 public PedidoController(PedidoService pedidoService,ClienteService clienteService,ProfissionalService profissionalService,ServicoService servicoService){this.pedidoService=pedidoService;this.clienteService=clienteService;this.profissionalService=profissionalService;this.servicoService=servicoService;}
 @GetMapping public String listar(Model model){model.addAttribute("pedidos",pedidoService.listar());return "pedidos/lista";}
 @GetMapping("/novo") public String novo(Model model){model.addAttribute("clientes",clienteService.listar());model.addAttribute("servicos",servicoService.listar());return "pedidos/form";}
 @PostMapping public String criar(@RequestParam Long clienteId,@RequestParam Long servicoId,@RequestParam int quantidade,@RequestParam String localidade,@RequestParam String descricao,RedirectAttributes flash){try{var pedido=pedidoService.criar(clienteId,servicoId,quantidade,localidade,descricao);flash.addFlashAttribute("sucesso","Demanda publicada com sucesso.");return "redirect:/pedidos/"+pedido.getNumero();}catch(RuntimeException ex){flash.addFlashAttribute("erro",ex.getMessage());return "redirect:/pedidos/novo";}}
 @GetMapping("/{numero}") public String detalhe(@PathVariable Long numero,Model model){model.addAttribute("pedido",pedidoService.buscar(numero));model.addAttribute("profissionais",profissionalService.listar());model.addAttribute("tiposPagamento",TipoPagamento.values());return "pedidos/detalhe";}
 @PostMapping("/{numero}/aceitar") public String aceitar(@PathVariable Long numero,@RequestParam Long profissionalId,RedirectAttributes flash){return executar(()->pedidoService.aceitar(numero,profissionalId),numero,"Demanda aceita pelo profissional.",flash);}
 @PostMapping("/{numero}/cancelar") public String cancelar(@PathVariable Long numero,RedirectAttributes flash){return executar(()->pedidoService.cancelar(numero),numero,"Serviço cancelado.",flash);}
 @PostMapping("/{numero}/finalizar") public String finalizar(@PathVariable Long numero,@RequestParam TipoPagamento tipoPagamento,@RequestParam String dadoPagamento,RedirectAttributes flash){return executar(()->pedidoService.finalizar(numero,tipoPagamento,dadoPagamento),numero,"Serviço finalizado e pagamento validado.",flash);}
 private String executar(Runnable acao,Long numero,String mensagem,RedirectAttributes flash){try{acao.run();flash.addFlashAttribute("sucesso",mensagem);}catch(RuntimeException ex){flash.addFlashAttribute("erro",ex.getMessage());}return "redirect:/pedidos/"+numero;}
}
