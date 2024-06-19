package com.rgelo.wallaswap5.service.implementatios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Anuncio;
import com.rgelo.wallaswap5.repository.AnuncioRepo;
import com.rgelo.wallaswap5.service.AnuncioService;

@Service
public class AnuncioServiceImpl implements AnuncioService {

	@Autowired
	private AnuncioRepo anuncioRepository;

	@Override
	public Anuncio guardarAnuncio(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}

	@Override
	public List<Anuncio> getanuncios(String username) {
		List<Anuncio> listaanuncios = anuncioRepository.findwithoutuser(username);
		return listaanuncios;
	}

	@Override
	public Anuncio findById(Long id) {
		return anuncioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Anuncio> findbyuser(String usuario) {
		return anuncioRepository.findbyuser(usuario);
	}

}
