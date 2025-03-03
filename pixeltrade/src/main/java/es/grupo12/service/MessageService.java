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

	public List<Message> findMessagesBetweenUsers(User user1, User user2) {
		return messageRepository.findMessagesBetweenUsers(user1, user2);
	}

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

	public void deleteById(long id) {
		messageRepository.deleteById(id);
	}

    public void deleteBySender(User user) {
        messageRepository.deleteBySender(user);
    }

    public void deleteByReceiver(User user) {
        messageRepository.deleteByReceiver(user);
    }
}
