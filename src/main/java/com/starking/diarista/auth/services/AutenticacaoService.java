package com.starking.diarista.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.starking.diarista.auth.model.UsuarioAutenticado;
import com.starking.diarista.core.repositories.UsuarioRepository;

public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		var mensagem = String.format("Usuário com email %s não encontrado", email); 
		
		return this.usuarioRepository.findByEmail(email)
				.map(UsuarioAutenticado::new)
				.orElseThrow(() -> new UsernameNotFoundException(mensagem));
	}
}
