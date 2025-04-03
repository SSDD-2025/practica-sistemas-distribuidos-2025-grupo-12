package es.grupo12.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.grupo12.dto.MessageDTO;
import es.grupo12.dto.MessageMapper;
import es.grupo12.dto.UserDTO;
import es.grupo12.model.Message;
import es.grupo12.model.Product;
import es.grupo12.model.Review;
import es.grupo12.model.User;
import es.grupo12.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
	private MessageRepository messageRepository;

	@Autowired
    private MessageMapper mapper;

	@Autowired
	private UserService userService;
	
    private MessageDTO toDTO (Message message) {
        return mapper.toDTO(message);
    }

    private Message toDomain (MessageDTO messageDTO) {
        return mapper.toDomain(messageDTO);
    }

    private List<MessageDTO> toDTOs(Collection<Message> messages){
        return mapper.toDTOs(messages);
    }

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

	public Collection<MessageDTO> getMessages() {
		return toDTOs(messageRepository.findAll());
	}

	public MessageDTO getMessage(long id) {
		return toDTO(messageRepository.findById(id).orElseThrow());
	}

    public MessageDTO deleteMessage(long id) {
        Message message = messageRepository.findById(id).orElseThrow();
		User sender = message.getSender();

		UserDTO logged = userService.getLoggedUser();
		if(sender.getId() == logged.id()) {
			messageRepository.deleteById(id);
 			return toDTO(message);
		}
		throw new RuntimeException();
 	
    }

    public MessageDTO createMessage(MessageDTO messageDTO) {
        Message message = toDomain(messageDTO);
 		messageRepository.save(message);
 		return toDTO(message);
    }
}
