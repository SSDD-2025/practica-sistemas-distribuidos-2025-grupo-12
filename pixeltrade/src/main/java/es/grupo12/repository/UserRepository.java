package es.grupo12.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.grupo12.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByMail(String mail);
    Optional<User> findByUsername(String username);
    @Query("SELECT DISTINCT u FROM User u " +
       "WHERE u.id <> :userId AND " +
       "(u IN (SELECT m.sender FROM Message m WHERE m.receiver.id = :userId) " +
       "OR u IN (SELECT m.receiver FROM Message m WHERE m.sender.id = :userId))")
    List<User> findUsersBySharedMessages(@Param("userId") Long userId);
}
