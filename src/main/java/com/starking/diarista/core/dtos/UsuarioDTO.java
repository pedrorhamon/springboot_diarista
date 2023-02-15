package com.starking.diarista.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.starking.diarista.core.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nomeCompleto;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String confirmaSenha;
	
	@NotNull
	private TipoUsuario tipoUsuario;

}
