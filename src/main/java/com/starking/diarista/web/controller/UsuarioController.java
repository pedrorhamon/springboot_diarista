package com.starking.diarista.web.controller;

import java.security.Principal;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starking.diarista.core.dtos.AlterarSenhaDTO;
import com.starking.diarista.core.dtos.FlashMessage;
import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.dtos.UsuarioEdicaoDTO;
import com.starking.diarista.core.enums.TipoUsuario;
import com.starking.diarista.web.exceptions.ValidacaoException;
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
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		var modelAndView = new ModelAndView("admin/usuario/form");
		return modelAndView.addObject("usuario", new UsuarioDTO());
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@Valid @ModelAttribute("form") UsuarioDTO usuarioDTO, BindingResult result, RedirectAttributes attrs) {
		if(result.hasErrors()) {
			return "admin/usuario/form";
		}
		try {
			this.usuarioService.cadastrar(usuarioDTO);
			attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário cadastrado com sucesso!"));
		}catch(ValidacaoException e) {
			result.addError(e.getFieldError());
			return "admin/usuario/form";
		}
		return "redirect:/admin/usuarios";
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		var modelAndView = new ModelAndView("admin/usuario/edicao");
		
		return modelAndView.addObject("usuario", this.usuarioService.editarPorId(id));
	}
	
	@PostMapping("/{id}/editar")
	public String editar(@PathVariable @ModelAttribute("form") Long id, UsuarioEdicaoDTO usuario, BindingResult result, RedirectAttributes attrs) {
		if(result.hasErrors()) {
			return "admin/usuario/form";
		}
		
		try {
			this.usuarioService.editar(usuario, id);
			attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário editado com sucesso!"));
		}catch(ValidacaoException e) {
			result.addError(e.getFieldError());
			return "admin/usuario/form";
		}
		return "redirect:/admin/usuarios";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
		this.usuarioService.excluirPorId(id);
		attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário excluido com sucesso!"));
		return "redirect:/admin/usuarios";
	}
	
	@GetMapping("/alterar-senha")
	public ModelAndView alterarSenha() {
		var modelAndView = new ModelAndView("/admin/usuario/alterar-senha");
		return modelAndView.addObject("alterarSenhaDTO", new AlterarSenhaDTO());
	}
	
	@PostMapping("/alterar-senha") 
	public String alterarSenha(@Valid @ModelAttribute("alterarSenhaDTO") AlterarSenhaDTO dto, BindingResult result, RedirectAttributes attrs, Principal principal) {
		if(result.hasErrors()) {
			return "admin/usuario/alterar-senha";
		}
		try {
			this.usuarioService.alterarSenha(dto, principal.getName());
			attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Senha Alterada com sucesso!"));
		}catch(ValidacaoException e) {
			result.addError(e.getFieldError());
			return "admin/usuario/alterar-senha";
		}
		return "redirect:/admin/usuarios/alterar-senha";
	}
	
	@ModelAttribute("tipoUsuarios")
	public TipoUsuario[] getTipoUsuario() {
		return TipoUsuario.values();
	}
}
