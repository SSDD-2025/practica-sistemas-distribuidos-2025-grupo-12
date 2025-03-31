package es.grupo12.controller.rest;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.grupo12.dto.ProductDTO;
import es.grupo12.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class RestProductController {

    

    @Autowired
    private ProductService productService;



    @GetMapping("/")
	public Collection<ProductDTO> getProducts() {
		return productService.getProducts();
	}

    @GetMapping("/{id}")
	public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
	}

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

        productDTO = productService.createProduct(productDTO);


        URI location = fromCurrentRequest().path("/{id}")
            .buildAndExpand(productDTO.id()).toUri();

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



}
