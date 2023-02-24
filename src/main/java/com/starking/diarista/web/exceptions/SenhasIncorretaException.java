package com.starking.diarista.web.exceptions;

import org.springframework.validation.FieldError;

public class SenhasIncorretaException extends ValidacaoException {
	
	private static final long serialVersionUID = 1L;

	public SenhasIncorretaException(String message, FieldError fieldError) {
		super(message, fieldError);
	}
}
