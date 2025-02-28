package es.grupo12.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import es.grupo12.model.Product;
import es.grupo12.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.title LIKE CONCAT(:title, '%')")
	List<Product> findByTitle(String title);

	List<Product> findByBuyerIsNull();
	List<Product> findByBuyer(User user);
	Optional<Product> findById(long id);

    List<Product> findBySeller(User user);
}
    

