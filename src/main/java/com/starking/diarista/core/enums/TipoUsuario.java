package com.starking.diarista.core.enums;

public enum TipoUsuario {

	ADMIN ("Admin"), 
	CLIENTE("Cliente"), 
	DIARISTA("Diarista");

	private String nome;

	private TipoUsuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
