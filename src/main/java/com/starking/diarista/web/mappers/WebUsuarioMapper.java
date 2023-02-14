package com.starking.diarista.web.mappers;

import org.springframework.stereotype.Component;

import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.model.Usuario;

@Component
public class WebUsuarioMapper {
	
	public Usuario toModel(UsuarioDTO usuarioDTO) {
		if(usuarioDTO == null) {
			throw new IllegalArgumentException();
		}
		var model = new Usuario();
		model.setNomeCompleto(usuarioDTO.getNomeCompleto());
		model.setEmail(usuarioDTO.getEmail());
		model.setSenha(usuarioDTO.getSenha());
		model.setTipoUsuario(usuarioDTO.getTipoUsuario());
		
		return model;
	}
	
	public UsuarioDTO toDTO(Usuario entity) {
		if(entity == null) {
			throw new IllegalArgumentException();
		}
		var dto = new UsuarioDTO();
		dto.setNomeCompleto(entity.getNomeCompleto());
		dto.setEmail(entity.getEmail());
		dto.setSenha(entity.getSenha());
		dto.setTipoUsuario(entity.getTipoUsuario());
		
		return dto;
	}
}
