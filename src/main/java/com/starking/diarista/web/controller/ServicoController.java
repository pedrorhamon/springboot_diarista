package com.starking.diarista.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.starking.diarista.core.enums.Icone;
import com.starking.diarista.core.model.Servico;
import com.starking.diarista.core.repositories.ServicoRepository;

@RestController
@RequestMapping("/admin/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping
	public ModelAndView buscarTodos() {
		var modelAndView = new ModelAndView("admin/servico/listar");
		return modelAndView.addObject("servicos", this.servicoRepository.findAll());
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		var modelAndView = new ModelAndView("admin/servico/form");
		return modelAndView.addObject("servico", new Servico());
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Servico servico) {
		this.servicoRepository.save(servico);
		return "redirect:/admin/servicos";
	}

	@ModelAttribute("icones")
	public Icone[] getIcones() {
		return Icone.values();
	}
}
