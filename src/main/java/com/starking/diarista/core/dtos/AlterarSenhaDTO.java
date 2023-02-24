package com.starking.diarista.core.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.starking.diarista.web.interfaces.IConfirmacaoSenha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterarSenhaDTO implements IConfirmacaoSenha{
	
	@NotNull
	@NotEmpty
	private String senhaAntiga;
	
	@NotNull
	@NotEmpty
	private String senha;
	
	@NotNull
	@NotEmpty
	private String ConfirmacaoSenha;

}
