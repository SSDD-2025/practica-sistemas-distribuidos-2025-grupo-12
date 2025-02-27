package es.grupo12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.grupo12.model.Message;
import es.grupo12.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySender(User user);
    List<Message> findByReceiver(User user);
}
