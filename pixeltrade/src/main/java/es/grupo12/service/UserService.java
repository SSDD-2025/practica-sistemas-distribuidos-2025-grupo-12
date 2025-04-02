package es.grupo12.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import es.grupo12.dto.UserDTO;
import es.grupo12.dto.UserMapper;
import es.grupo12.model.User;
import es.grupo12.repository.MessageRepository;
import es.grupo12.repository.ProductRepository;
import es.grupo12.repository.ReviewRepository;
import es.grupo12.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
    private UserMapper mapper;

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

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
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

	public UserDTO getLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return toDTO(userRepository.findByUsername(username).orElseThrow());
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
	private UserDTO toDTO (User user) {
        return mapper.toDTO(user);
    }

    private User toDomain (UserDTO userDTO) {
        return mapper.toDomain(userDTO);
    }

    private List<UserDTO> toDTOs(Collection<User> users){
        return mapper.toDTOs(users);
    }

	public Collection<UserDTO> getUsers() {
		return toDTOs(userRepository.findAll());
	}

	public UserDTO getUser(long id) {
		return toDTO(userRepository.findById(id).orElseThrow());
	}

    public UserDTO deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow();
 		userRepository.deleteById(id);
 		return toDTO(user);
    }

	public UserDTO createUser(UserDTO userDTO) {
		User user = toDomain(userDTO);
 		userRepository.save(user);
 		return toDTO(user);
	}


	
}
