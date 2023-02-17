package com.starking.diarista.web.exceptions;

import org.springframework.validation.FieldError;

public class UsuarioJaCadastradoException extends ValidacaoException {

	private static final long serialVersionUID = 1L;

	public UsuarioJaCadastradoException(String message, FieldError fieldError) {
		super(message, fieldError);
	}
}
