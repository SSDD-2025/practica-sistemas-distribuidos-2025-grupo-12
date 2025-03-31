package es.grupo12.controller.rest;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

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
import es.grupo12.dto.ProductMapper;
import es.grupo12.model.Product;
import es.grupo12.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class RestProductController {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService productService;


    private ProductDTO toDTO (Product product) {
        return mapper.toDTO(product);
    }

    private Product toDomain (ProductDTO productDTO) {
        return mapper.toDomain(productDTO);
    }

    private List<ProductDTO> toDTOs(Collection<Product> products){
        return mapper.toDTOs(products);
    }

    @GetMapping("/")
	public Collection<ProductDTO> getProducts() {
        List<Product> allProducts = productService.findAll();
		return toDTOs(allProducts);
	}

    @GetMapping("/{id}")
	public ProductDTO getProduct(@PathVariable long id) {
        return toDTO(productService.findById(id).orElseThrow());
	}

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

        Product product = toDomain(productDTO);

        productService.save(product);

        URI location = fromCurrentRequest().path("/{id}")
            .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(toDTO(product));
    }

    @PutMapping("/{id}")
    public ProductDTO replaceProduct(@PathVariable long id, @RequestBody ProductDTO newProductDTO) {
        if (productService.exist(id)) {
            Product newProduct = toDomain(newProductDTO);
            newProduct.setId(id);
            productService.save(newProduct);
            return toDTO(newProduct);
        } else {
            throw new NoSuchElementException();
        }
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable long id) {
        Product product = productService.findById(id).orElseThrow();
        productService.deleteById(id);
        return toDTO(product);
    }



}
