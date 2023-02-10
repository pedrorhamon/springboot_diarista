package com.starking.diarista.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.starking.diarista.core.dtos.ServicoDTO;
import com.starking.diarista.core.enums.Icone;
import com.starking.diarista.core.repositories.ServicoRepository;
import com.starking.diarista.web.mappers.WebServicoMapper;

@RestController
@RequestMapping("/admin/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private WebServicoMapper servicoMapper;
	
	@GetMapping
	public ModelAndView buscarTodos() {
		var modelAndView = new ModelAndView("admin/servico/listar");
		return modelAndView.addObject("servicos", this.servicoRepository.findAll());
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		var modelAndView = new ModelAndView("admin/servico/form");
		return modelAndView.addObject("servico", new ServicoDTO());
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@Valid @ModelAttribute("dto") ServicoDTO servicoDto, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/servico/form";
		}
		var servico = servicoMapper.toModel(servicoDto);
		this.servicoRepository.save(servico);
		return "redirect:/admin/servicos";
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		var modelAndView = new ModelAndView("admin/servico/form");
		
		var servico = this.servicoRepository.getById(id);
		var dto = servicoMapper.toDTO(servico);
		return modelAndView.addObject("servico", dto);
	}
	
	@PostMapping("/{id}/editar")
	public String editar(@PathVariable @ModelAttribute("form") Long id, ServicoDTO servicoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/servico/form";
		}
		var servico = servicoMapper.toModel(servicoDTO);
		
		servico.setId(id);
		this.servicoRepository.save(servico);
		
		return "redirect:/admin/servicos";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		this.servicoRepository.deleteById(id);
		return "redirect:/admin/servicos";
	}

	@ModelAttribute("icones")
	public Icone[] getIcones() {
		return Icone.values();
	}
}
