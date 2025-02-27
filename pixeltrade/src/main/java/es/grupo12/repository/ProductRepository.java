package es.grupo12.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import es.grupo12.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.title LIKE CONCAT(:title, '%')")
	List<Product> findByTitle(String title);

	List<Product> findByBuyerIsNull();
	
	Optional<Product> findById(long id);
}
    

