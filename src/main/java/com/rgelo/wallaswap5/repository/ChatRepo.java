package com.rgelo.wallaswap5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rgelo.wallaswap5.entities.Chat;

public interface ChatRepo extends JpaRepository<Chat, Long> {

	public List<Chat> findAll();

	@Query("SELECT c FROM Chat c WHERE c.usuario1.id = :userId OR c.usuario2.id = :userId")
	List<Chat> findChatsByUserId(@Param("userId") Long userId);
}
