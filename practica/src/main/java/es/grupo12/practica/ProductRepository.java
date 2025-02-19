package es.grupo12.practica;

import java.util.List;
import org.springframework.data.jpa.repository.*;;;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByTitle(String title);
	
}
    

