package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.domain.Servico;
import br.edu.ifpa.construmob.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
@Controller @RequestMapping("/servicos") public class ServicoController{private final ServicoService service;public ServicoController(ServicoService service){this.service=service;}@GetMapping public String listar(Model model){model.addAttribute("servicos",service.listar());return "servicos/lista";}@GetMapping("/novo") public String novo(Model model){model.addAttribute("servico",new Servico("","",BigDecimal.ZERO));return "servicos/form";}@PostMapping public String salvar(@Valid @ModelAttribute Servico servico,BindingResult result){if(result.hasErrors())return "servicos/form";service.salvar(servico);return "redirect:/servicos";}}
