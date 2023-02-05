package com.starking.diarista.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.starking.diarista.core.model.Servico;
import com.starking.diarista.core.repositories.ServicoRepository;

@RestController
@RequestMapping("/admin/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		var modelAndView = new ModelAndView("admin/servico/form");
		modelAndView.addObject("servico", new Servico());
		return modelAndView;
	}

}
