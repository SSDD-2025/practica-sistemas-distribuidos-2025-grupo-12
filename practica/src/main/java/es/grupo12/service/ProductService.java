package es.grupo12.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import es.grupo12.repository.*;
import es.grupo12.model.*;


@Service
public class ProductService {


	@Autowired
	private ProductRepository ProductRepository;

	public Optional<Product> findById(long id) {
		return ProductRepository.findById(id);
	}
	
	public boolean exist(long id) {
		return ProductRepository.existsById(id);
	}

	public List<Product> findAll() {
		return ProductRepository.findAll();
	}

	public Product save(Product product, User vendor) {

		return ProductRepository.save(product);
	}
}
