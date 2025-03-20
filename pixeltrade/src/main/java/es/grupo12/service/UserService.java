package es.grupo12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.grupo12.model.User;
import es.grupo12.repository.MessageRepository;
import es.grupo12.repository.ProductRepository;
import es.grupo12.repository.ReviewRepository;
import es.grupo12.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {


	@Autowired
	private UserRepository userRepository;

	
	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ReviewRepository reviewRepository;
	
	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	public List<User> findByMail(String mail) {
		return userRepository.findByMail(mail);
	}

	public List<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<User> findByName(String username) {
		return userRepository.findByName(username);
	}

	public boolean exist(long id) {
		return userRepository.existsById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user){
		return userRepository.save(user);
	}

    
    @Transactional 
    public void deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getId()!= 1){
				productRepository.deleteBySeller(user);
				messageRepository.deleteBySender(user);
				messageRepository.deleteByReceiver(user);
				reviewRepository.deleteByAuthor(user);
				reviewRepository.deleteBySeller(user);

				
				userRepository.delete(user);
			}
            
        }
    
    }


	
}
