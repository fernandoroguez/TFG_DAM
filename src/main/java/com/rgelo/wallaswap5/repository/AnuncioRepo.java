package com.rgelo.wallaswap5.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rgelo.wallaswap5.entities.Anuncio;

public interface AnuncioRepo extends JpaRepository<Anuncio, Long> {

	public List<Anuncio> findAll();
	
	@Query("SELECT a FROM Anuncio a WHERE a.usuario.Id IN (SELECT u.Id FROM Usuario u WHERE u.nombreUsuario = :pnombreusu)")
	List<Anuncio> findbyuser(@Param("pnombreusu") String pnombreusu);

	@Query("SELECT a FROM Anuncio a WHERE a.usuario.Id NOT IN (SELECT u.Id FROM Usuario u WHERE u.nombreUsuario = :pnombreusu)")
	List<Anuncio> findwithoutuser(@Param("pnombreusu") String pnombreusu);
	
}
