package com.rgelo.wallaswap5.service.implementatios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgelo.wallaswap5.entities.Chat;
import com.rgelo.wallaswap5.repository.ChatRepo;
import com.rgelo.wallaswap5.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	 @Autowired
	 private ChatRepo chatRepository;
	 
	@Override
	public List<Chat> getListadoDeChatsPorUsuario(Long id) {
		return chatRepository.findChatsByUserId(id);
	}

	@Override
	public Chat findbyId(Long id) {
		// TODO Auto-generated method stub
		return chatRepository.findById(id).orElse(null);
	}

}
