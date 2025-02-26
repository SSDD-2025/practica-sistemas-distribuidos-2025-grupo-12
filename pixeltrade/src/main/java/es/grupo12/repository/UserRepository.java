package es.grupo12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.grupo12.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByMail(String mail);
    List<User> findByUsername(String username);
}
