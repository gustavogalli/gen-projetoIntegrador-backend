package com.projetointegradorg3.redeSocial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegradorg3.redeSocial.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String usuario);
	
}