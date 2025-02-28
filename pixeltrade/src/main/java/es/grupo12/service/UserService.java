package es.grupo12.service;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.grupo12.model.User;
import es.grupo12.repository.UserRepository;
import jakarta.servlet.http.HttpSession;;

@Service
public class UserService {


	@Autowired
	private UserRepository UserRepository;

	

	public Optional<User> findById(long id) {
		return UserRepository.findById(id);
	}

	public List<User> findByMail(String mail) {
		return UserRepository.findByMail(mail);
	}

	public List<User> findByUsername(String username) {
		return UserRepository.findByUsername(username);
	}
	public boolean exist(long id) {
		return UserRepository.existsById(id);
	}

	public List<User> findAll() {
		return UserRepository.findAll();
	}

	public User save(User user){
		return UserRepository.save(user);
	}


	
}
