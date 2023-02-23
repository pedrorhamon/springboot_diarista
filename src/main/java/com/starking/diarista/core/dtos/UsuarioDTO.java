package com.starking.diarista.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.starking.diarista.web.interfaces.IConfirmacaoSenha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements IConfirmacaoSenha{
	
	@NotNull
	@Size(min = 3, max = 250)
	private String nomeCompleto;
	
	@Email
	@NotNull
	@Size(min = 3, max = 250)
	private String email;
	
	@NotNull
	@NotEmpty
	private String senha;
	
	@NotNull
	@NotEmpty
	private String confirmacaoSenha;


}
