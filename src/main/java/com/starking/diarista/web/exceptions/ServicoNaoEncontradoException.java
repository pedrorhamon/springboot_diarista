package com.starking.diarista.web.exceptions;

import javax.persistence.EntityNotFoundException;

public class ServicoNaoEncontradoException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ServicoNaoEncontradoException(String msg) {
		super(msg);
	}

}
