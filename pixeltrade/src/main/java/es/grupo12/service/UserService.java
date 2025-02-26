package es.grupo12.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.grupo12.model.User;
import es.grupo12.repository.UserRepository;;

@Service
public class UserService {


	@Autowired
	private UserRepository UserRepository;

	public Optional<User> findById(long id) {
		return UserRepository.findById(id);
	}

	public List<User> findByTitle(String mail) {
		return UserRepository.findByMail(mail);
	}
	
	public boolean exist(long id) {
		return UserRepository.existsById(id);
	}

	public List<User> findAll() {
		return UserRepository.findAll();
	}

	public User save(User User) throws IOException {

		return UserRepository.save(User);
	}
}
