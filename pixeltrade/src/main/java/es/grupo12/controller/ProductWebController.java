package es.grupo12.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import es.grupo12.model.Product;
import es.grupo12.repository.ProductRepository;
import es.grupo12.service.ProductService;



@Controller
public class ProductWebController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String showRecommended(Model model) {
		List<Product> allProducts = productService.findByBuyerIsNull();
    	List<Product> limitedProducts = allProducts.stream().limit(3).toList(); // Máximo 3
		model.addAttribute("products", limitedProducts);
		return "mainweb";
	}


	@GetMapping("/products")
	public String showProducts(Model model) {
		model.addAttribute("products", productService.findByBuyerIsNull());
		return "products";
	}

	@GetMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable long id) {

		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
			return "productPage";
		} else {
			return "productNotFound";
		}

	}

	@GetMapping("/search")
	public String searchProduct(Model model, @RequestParam("title") String title) {

		List<Product> products = productService.findByTitle(title).stream().filter(product -> product.getBuyer() == null).toList();
		model.addAttribute("found", products);
		return "foundProducts";
	}

	@GetMapping("/upload_product")
	public String uploadProduct(Model model) {
		return "uploadProduct";
	}

	@PostMapping("/uploaded_product")
	public String uploadedProduct(Model model, @RequestParam String title, @RequestParam MultipartFile image, @RequestParam String description, @RequestParam double price) throws IOException {
		Product newprod = new Product(title, description, price, null, null);
		productService.save(newprod, image);
		return "uploadedProduct";
	}

}
