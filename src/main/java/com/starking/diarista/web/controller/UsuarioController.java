package com.starking.diarista.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.starking.diarista.web.service.WebUsuarioService;

@RestController
@RequestMapping("/admin/usuarios")
public class UsuarioController {

	@Autowired
	private WebUsuarioService usuarioService;
	
	@GetMapping
	public ModelAndView buscarTodos() {
		var modelAndView = new ModelAndView("admin/usuario/listar");
		return modelAndView.addObject("usuarios", this.usuarioService.buscarTodos());
	}
}
