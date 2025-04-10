package es.grupo12.controller.rest;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.grupo12.dto.ProductDTO;
import es.grupo12.dto.ProductMapper;
import es.grupo12.model.Product;
import es.grupo12.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper mapper;

    @GetMapping("/")
	public Page<ProductDTO> getProducts(Pageable pageable) {
        return productService.findAll(pageable).map(this::toDTO);
	}

    @GetMapping("/{id}")
	public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
	}

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        productDTO = productService.createProduct(productDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(productDTO.id()).toUri();
        return ResponseEntity.created(location).body(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO replaceProduct(@PathVariable long id, @RequestBody ProductDTO updatedProductDTO) {
        return productService.replaceProduct(id, updatedProductDTO);
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Object> createProductImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException {
        productService.createProductImage(id, imageFile.getInputStream(), imageFile.getSize());
        URI location = fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Object> getProductImage(@PathVariable long id) throws SQLException, IOException {
        Resource productImage = productService.getProductImage(id);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(productImage);
    }
    
    private ProductDTO toDTO(Product product){
		return mapper.toDTO(product);
	}
}
