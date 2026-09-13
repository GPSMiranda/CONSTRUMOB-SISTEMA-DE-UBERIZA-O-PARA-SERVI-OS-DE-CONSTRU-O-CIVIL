package br.edu.ifpa.construmob.controller;
import br.edu.ifpa.construmob.domain.Profissional;
import br.edu.ifpa.construmob.service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/profissionais") public class ProfissionalController{private final ProfissionalService service;public ProfissionalController(ProfissionalService service){this.service=service;}@GetMapping public String listar(Model model){model.addAttribute("profissionais",service.listar());return "profissionais/lista";}@GetMapping("/novo") public String novo(Model model){model.addAttribute("profissional",new Profissional("","","",""));return "profissionais/form";}@PostMapping public String salvar(@Valid @ModelAttribute Profissional profissional,BindingResult result){if(result.hasErrors())return "profissionais/form";service.salvar(profissional);return "redirect:/profissionais";}@PostMapping("/{id}/validar") public String validar(@PathVariable Long id){service.validar(id);return "redirect:/profissionais";}}
