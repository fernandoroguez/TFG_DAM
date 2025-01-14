package com.rgelo.wallaswap5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Usuario;
import com.rgelo.wallaswap5.repository.UsuarioRepo;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usu = repo.findByNombreUsuario(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userdet = new User(usu.getNombreUsuario(), usu.getContrasenia(), authorities);
		return userdet;
	}

}
