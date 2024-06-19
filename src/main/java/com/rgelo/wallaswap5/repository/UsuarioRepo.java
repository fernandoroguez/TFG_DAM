package com.rgelo.wallaswap5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgelo.wallaswap5.entities.Usuario;


public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

	public List<Usuario> findAll();
	
	public Usuario findByNombreUsuario(String nombreUsuario);

}
	