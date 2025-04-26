package es.grupo12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.grupo12.model.Review;
import es.grupo12.model.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

    List<Review> findBySeller(User user);

    List<Review> findByAuthor(User user);

    void deleteByAuthor(User user);

    void deleteBySeller(User user);
    
}
