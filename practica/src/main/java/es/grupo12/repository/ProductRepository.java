package es.grupo12.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;

import es.grupo12.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByTitle(String title);
	
}
    

