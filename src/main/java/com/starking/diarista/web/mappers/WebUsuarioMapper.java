package com.starking.diarista.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.starking.diarista.core.dtos.UsuarioDTO;
import com.starking.diarista.core.dtos.UsuarioEdicaoDTO;
import com.starking.diarista.core.model.Usuario;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {
	
	WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);
	
	Usuario toModel(UsuarioDTO dto);
	
	Usuario toModel(UsuarioEdicaoDTO dto);
	
	UsuarioEdicaoDTO toDTO(Usuario model);
	
}
