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
import es.grupo12.service.ProductService;



@Controller
public class ProductWebController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String showRecommended(Model model) {
		List<Product> allProducts = productService.findAll();
    	List<Product> limitedProducts = allProducts.stream().limit(3).toList(); // Máximo 3
		model.addAttribute("products", limitedProducts);
		return "mainweb";
	}


	@GetMapping("/products")
	public String showBooks(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}

	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable long id) {

		Optional<Product> book = productService.findById(id);
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			return "book";
		} else {
			return "books";
		}

	}

}
