package com.starking.diarista.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.diarista.core.model.Usuario;
import com.starking.diarista.core.repositories.UsuarioRepository;

@Service
public class WebUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}
}
