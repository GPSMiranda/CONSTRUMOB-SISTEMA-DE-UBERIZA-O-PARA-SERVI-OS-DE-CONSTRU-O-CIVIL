package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/avaliacoes") public class AvaliacaoController{private final AvaliacaoService avaliacaoService;private final PedidoService pedidoService;public AvaliacaoController(AvaliacaoService avaliacaoService,PedidoService pedidoService){this.avaliacaoService=avaliacaoService;this.pedidoService=pedidoService;}@GetMapping("/nova/{pedidoId}") public String nova(@PathVariable Long pedidoId,Model model){model.addAttribute("pedido",pedidoService.buscar(pedidoId));return "avaliacoes/form";}@PostMapping public String salvar(@RequestParam Long pedidoId,@RequestParam int nota,@RequestParam(required=false) String comentario,RedirectAttributes flash){try{avaliacaoService.avaliar(pedidoId,nota,comentario);flash.addFlashAttribute("sucesso","Avaliação registrada.");}catch(RuntimeException ex){flash.addFlashAttribute("erro",ex.getMessage());}return "redirect:/pedidos/"+pedidoId;}}
