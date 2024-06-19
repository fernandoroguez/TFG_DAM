package com.rgelo.wallaswap5.service.implementatios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rgelo.wallaswap5.entities.Usuario;
import com.rgelo.wallaswap5.repository.UsuarioRepo;
import com.rgelo.wallaswap5.service.UsuarioService;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{


	
	@Autowired
	private UsuarioRepo usuariorepo;
	
	@Override
	public Usuario insertar(Usuario usuario) {
		return usuariorepo.save(usuario);
	}

	@Override
	public List<Usuario> lisarUsuarios() {
		return usuariorepo.findAll();
	}

	@Override
	public Usuario getById(Long id) {
		return usuariorepo.findById(id).orElse(null);
	}

	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		 Usuario usuario = usuariorepo.findByNombreUsuario(nombreUsuario);
	        if (usuario == null) {
	            throw new UsernameNotFoundException("Usuario no encontrado");
	        }
	        return usuario;
	    }
	 public Usuario crearUsuario(Usuario usuario) {
	        // Encriptar la contraseña antes de guardarla
	        usuario.setContrasenia(usuario.getContrasenia());
	        return usuariorepo.save(usuario);
	    }

	@Override
	public String obtenerUsuarioAutenticado() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	            return userDetails.getUsername(); // O cualquier otro detalle que necesites
	        }
	        return null;
	    }


}
