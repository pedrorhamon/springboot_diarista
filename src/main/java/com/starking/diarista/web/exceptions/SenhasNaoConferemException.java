package com.starking.diarista.web.exceptions;

import org.springframework.validation.FieldError;

public class SenhasNaoConferemException extends ValidacaoException {
	
	private static final long serialVersionUID = 1L;

	public SenhasNaoConferemException(String message, FieldError fieldError) {
		super(message, fieldError);
	}
}
