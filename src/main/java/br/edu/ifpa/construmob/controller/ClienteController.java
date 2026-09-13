package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.domain.Cliente;
import br.edu.ifpa.construmob.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/clientes") public class ClienteController{private final ClienteService service;public ClienteController(ClienteService service){this.service=service;}@GetMapping public String listar(Model model){model.addAttribute("clientes",service.listar());return "clientes/lista";}@GetMapping("/novo") public String novo(Model model){model.addAttribute("cliente",new Cliente("","",""));return "clientes/form";}@PostMapping public String salvar(@Valid @ModelAttribute Cliente cliente,BindingResult result){if(result.hasErrors())return "clientes/form";service.salvar(cliente);return "redirect:/clientes";}}
