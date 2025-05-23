package es.grupo12.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.grupo12.dto.ProductDTO;
import es.grupo12.dto.ProductMapper;
import es.grupo12.model.Product;
import es.grupo12.model.User;
import es.grupo12.repository.ProductRepository;

@Service
public class ProductService {


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserService userService;

	@Autowired
    private ProductMapper mapper;
	
    private ProductDTO toDTO (Product product) {
        return mapper.toDTO(product);
    }

    private Product toDomain (ProductDTO productDTO) {
        return mapper.toDomain(productDTO);
    }

    private List<ProductDTO> toDTOs(Collection<Product> products){
        return mapper.toDTOs(products);
    }

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}
	
	public List<ProductDTO> findByTitle(String title) {
		return toDTOs(productRepository.findByTitle(title));
	}
	
	public boolean exist(long id) {
		return productRepository.existsById(id);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	public ProductDTO save(Product product,MultipartFile imageField) throws IOException {
		if (imageField != null && !imageField.isEmpty()){
			product.setImg(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
		}
		return toDTO(productRepository.save(product));
	}

	public ProductDTO save(Product product) {
		return toDTO(productRepository.save(product));
	}

	public List<ProductDTO> findByBuyerIsNull() {
		return toDTOs(productRepository.findByBuyerIsNull());
	}

	public List<ProductDTO> findByBuyer(User user) {
		return toDTOs(productRepository.findByBuyer(user));
	}

	public List<ProductDTO> findBySeller(User user) {
		return toDTOs(productRepository.findBySeller(user));
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	public void deleteBySeller(User user) {
		productRepository.deleteBySeller(user);
	}

	public Collection<ProductDTO> getProducts() {
		return toDTOs(productRepository.findAll());
	}

    public ProductDTO getProduct(long id) {
        return toDTO(productRepository.findById(id).orElseThrow());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
		User loggedUser = userService.getLoggedUser();
        Product product = toDomain(productDTO);
		product.setSeller(loggedUser);
 		productRepository.save(product);
 		return toDTO(product);
    }

    public ProductDTO replaceProduct(long id, ProductDTO updatedProductDTO) {
        if (productRepository.existsById(id)) {
			Product product = productRepository.findById(id).orElseThrow();
			Product updatedProduct = toDomain(updatedProductDTO);
			updatedProduct.setId(id);
			updatedProduct.setImg(product.getImg());
			User loggedUser = userService.getLoggedUser();
			updatedProduct.setSeller(loggedUser);
			productRepository.save(updatedProduct);
			return toDTO(updatedProduct);
 		} else {
 			throw new NoSuchElementException();
 		}
    }

    public ProductDTO deleteProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow();
 		productRepository.deleteById(id);
 		return toDTO(product);
    }

	public void createProductImage(long id, InputStream inputStream, long size) { 
		Product product = productRepository.findById(id).orElseThrow();
		product.setImg(BlobProxy.generateProxy(inputStream, size)); 
		productRepository.save(product); 
	}

	public void replaceProductImage(long id, InputStream inputStream, long size) {
		Product product = productRepository.findById(id).orElseThrow();

		if(product.getImg() == null){
			throw new NoSuchElementException();
		}

		product.setImg(BlobProxy.generateProxy(inputStream, size));

		productRepository.save(product);
	}

    public Resource getProductImage(long id) throws SQLException{
		Product product = productRepository.findById(id).orElseThrow();

		if (product.getImg() != null) {
			return new InputStreamResource(product.getImg().getBinaryStream());
		} else {
			throw new NoSuchElementException();
		}
    }

	public Page<ProductDTO> getProducts(Pageable pageable) {
		return productRepository.findByBuyerIsNull(pageable).map(mapper::toDTO);
	}
	
}
