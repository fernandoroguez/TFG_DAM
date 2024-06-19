package com.rgelo.wallaswap5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Usuario;

@Service
public interface UsuarioService {

	//metodos para el controlador
	public Usuario insertar(Usuario usuario);
	public List<Usuario> lisarUsuarios();
	public Usuario getById(Long id);
	public Usuario findByNombreUsuario(String nombreUsuario);
	public Usuario crearUsuario(Usuario usuario);
	public String obtenerUsuarioAutenticado();
}

