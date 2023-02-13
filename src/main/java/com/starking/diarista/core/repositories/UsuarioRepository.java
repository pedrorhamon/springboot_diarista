package com.starking.diarista.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.diarista.core.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
