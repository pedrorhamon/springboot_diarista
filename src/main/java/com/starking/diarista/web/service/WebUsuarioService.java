package com.starking.diarista.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.dtos.UsuarioEdicaoDTO;
import com.starking.diarista.core.enums.TipoUsuario;
import com.starking.diarista.core.model.Usuario;
import com.starking.diarista.core.repositories.UsuarioRepository;
import com.starking.diarista.web.exceptions.UsuarioNaoEncontradoException;
import com.starking.diarista.web.mappers.WebUsuarioMapper;

@Service
public class WebUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired(required = false)
	private WebUsuarioMapper mapper;
	
	public List<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}
	
	@Transactional
	public Usuario cadastrar(UsuarioDTO usuarioDTO) {
		var model = this.mapper.toModel(usuarioDTO);
		model.setTipoUsuario(TipoUsuario.ADMIN);
		
		return this.usuarioRepository.save(model);
	}

	public Usuario buscarPorId(Long id) {
		var mensagem = String.format("Usuario com ID %d não encontrado", id);
		return this.usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
	}

	public UsuarioEdicaoDTO editarPorId(Long id) {
		var usuarioEncontrado = buscarPorId(id);
		return this.mapper.toDTO(usuarioEncontrado);
	}
	
	public Usuario editar(UsuarioEdicaoDTO dto, Long id) {
		var usuario = buscarPorId(id);
		
		var model = this.mapper.toModel(dto);
		model.setId(usuario.getId());
		model.setSenha(usuario.getSenha());
		model.setTipoUsuario(usuario.getTipoUsuario());
		
		return this.usuarioRepository.save(model);
		
	}

	public void excluirPorId(Long id) {
		var usuarioEncontrado = buscarPorId(id);

		this.usuarioRepository.delete(usuarioEncontrado);
	}
}
