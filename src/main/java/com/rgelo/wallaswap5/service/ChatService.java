package com.rgelo.wallaswap5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Chat;

@Service
public interface ChatService {
	
	public List<Chat> getListadoDeChatsPorUsuario(Long id);
	
	public Chat findbyId(Long id);
}
