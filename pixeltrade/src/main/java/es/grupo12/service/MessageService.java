package es.grupo12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.grupo12.model.Message;
import es.grupo12.model.User;
import es.grupo12.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
	private MessageRepository messageRepository;

		public Message save(Message message) {
		return messageRepository.save(message);
	}

    public List<Message> findBySender(User user) {
		return messageRepository.findBySender(user);
	}

    public List<Message> findByReceiver(User user) {
		return messageRepository.findByReceiver(user);
	}
}
