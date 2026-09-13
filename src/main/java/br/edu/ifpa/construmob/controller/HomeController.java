package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeController{private final PedidoService pedidoService;public HomeController(PedidoService pedidoService){this.pedidoService=pedidoService;}@GetMapping("/") public String home(Model model){model.addAttribute("pedidos",pedidoService.listar().stream().limit(5).toList());return "index";}}
