package com.starking.diarista.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.model.Usuario;
import com.starking.diarista.core.repositories.UsuarioRepository;
import com.starking.diarista.web.mappers.WebUsuarioMapper;

@Service
public class WebUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private WebUsuarioMapper mapper;
	
	public List<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Usuario cadastrar(UsuarioDTO usuarioDTO) {
		var model = this.mapper.toModel(usuarioDTO);
		
		return this.usuarioRepository.save(model);
	}
}
