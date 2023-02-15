package com.starking.diarista.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.model.Usuario;
import com.starking.diarista.core.repositories.UsuarioRepository;
import com.starking.diarista.web.exceptions.UsuarioNaoEncontradoException;
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
	
	@Transactional
	public Usuario cadastrar(UsuarioDTO usuarioDTO) {
		var model = this.mapper.toModel(usuarioDTO);
		
		return this.usuarioRepository.save(model);
	}

	public Usuario buscarPorId(Long id) {
		var usuarioEncontrado = this.usuarioRepository.findById(id);
		if(usuarioEncontrado.isPresent()) {
			return usuarioEncontrado.get();
		}
		
		var mensagem = String.format("Usuario com ID %d não encontrado", id);
		throw new UsuarioNaoEncontradoException(mensagem);
	}

	public Usuario editar(UsuarioDTO usuarioDTO, Long id) {
		var usuarioEncontrado = buscarPorId(id);
		var model = this.mapper.toModel(usuarioDTO);
		model.setId(usuarioEncontrado.getId());
		
		return this.usuarioRepository.save(model);
	}

	public void excluirPorId(Long id) {
		var usuarioEncontrado = buscarPorId(id);

		this.usuarioRepository.delete(usuarioEncontrado);
	}
}
