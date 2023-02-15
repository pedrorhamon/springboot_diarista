package com.starking.diarista.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEdicaoDTO {
	
	@NotNull
	@Size(min = 3, max = 255)
	private String nomeCompleto;
	
	@Email
	@Size(min = 3, max = 255)
	@NotNull
	private String email;

}
