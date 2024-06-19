package com.rgelo.wallaswap5.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Anuncio;

@Service
public interface AnuncioService {

	public List<Anuncio> getanuncios(String username);
	
	public Anuncio findById(Long id);

	public List<Anuncio> findbyuser(String username);
	
	public Anuncio guardarAnuncio(Anuncio anuncio);

}
