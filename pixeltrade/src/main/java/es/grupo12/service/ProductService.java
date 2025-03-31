package es.grupo12.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.grupo12.model.Product;
import es.grupo12.model.User;
import es.grupo12.repository.ProductRepository;;

@Service
public class ProductService {


	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findByTitle(String title) {
		return productRepository.findByTitle(title);
	}
	
	public boolean exist(long id) {
		return productRepository.existsById(id);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product product,MultipartFile imageField) throws IOException {
		if (imageField != null && !imageField.isEmpty()){
			product.setImg(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
		}
		return productRepository.save(product);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findByBuyerIsNull() {
		return productRepository.findByBuyerIsNull();
	}

	public List<Product> findByBuyer(User user) {
		return productRepository.findByBuyer(user);
	}

	public List<Product> findBySeller(User user) {
		return productRepository.findBySeller(user);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	public void deleteBySeller(User user) {
		productRepository.deleteBySeller(user);
	}

}
