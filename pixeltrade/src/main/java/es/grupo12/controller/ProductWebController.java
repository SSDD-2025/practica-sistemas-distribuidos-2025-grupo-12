package es.grupo12.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import es.grupo12.model.Product;
import es.grupo12.model.User;

import es.grupo12.service.ProductService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class ProductWebController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
		} else {
			model.addAttribute("logged", false);
		}
	}
 


	@GetMapping("/")
	public String showRecommended(Model model) {
		List<Product> allProducts = productService.findByBuyerIsNull();
		Collections.shuffle(allProducts);
    	List<Product> limitedProducts = allProducts.stream().limit(3).toList(); // Max 3
		model.addAttribute("products", limitedProducts);
		return "mainweb";
	}


	@GetMapping("/products")
	public String showProducts(Model model) {
		model.addAttribute("products", productService.findByBuyerIsNull());
		return "products";
	}

	@GetMapping("/allProducts")
	public String showAllProducts(Model model) {
		model.addAttribute("products", productService.findAll());
		return "allProducts";
	}

	@GetMapping("/uploadProduct")
	public String uploadProduct(Model model) {
		return "uploadProduct";
	}

	@GetMapping("/purchases")
	public String showPurchases(Model model) {
		String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
		model.addAttribute("products", productService.findByBuyer(user));
		return "purchases";
	}

	@GetMapping("/sales")
	public String showSales(Model model) {
		String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
		model.addAttribute("products", productService.findBySeller(user));
		return "sales";
	}

	@GetMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable long id) {
		String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
		model.addAttribute(user);

		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());

			if (user != null && product.get().getSeller().getId() == user.getId()) {
				model.addAttribute("isOwnProduct", true);
			} else {
				model.addAttribute("isOwnProduct", false);
			}

			return "productPage";
		} else {
			return "productNotFound";
		}

	}

	@GetMapping("/edit_product/{id}")
	public String editProduct(Model model, @PathVariable long id) {
		String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));

		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
			return "editProductPage"; 
		} else {
			return "productNotFound";
		}

	}

	@PostMapping("/update_product/{id}")
	public String updateProduct(Model model, @PathVariable long id, @RequestParam String title, @RequestParam String description, @RequestParam double price, @RequestParam long sellerId, @RequestParam(required = false) MultipartFile image) throws IOException {

		Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		product.setTitle(title);
		product.setDescr(description);
		product.setPrice(price);

		if (image != null && !image.isEmpty()) {
			productService.save(product, image);
		}
		else {
			productService.save(product);
		}

    	return "updatedProduct"; 
	}

	@PostMapping("/delete_product/{id}")
	public String deleteProduct(Model model, @PathVariable long id) throws IOException {

		productService.deleteById(id);

    	return "deletedProduct"; 
	}

	@PostMapping("/delete_productFromList/{id}")
	public String deleteProduct2(@PathVariable long id) throws IOException {

		productService.deleteById(id);

    	return "redirect:/allProducts"; 
	}
	

	@GetMapping("/search")
	public String searchProduct(Model model, @RequestParam("title") String title) {
		
		List<Product> products = productService.findByTitle(title).stream().filter(product -> product.getBuyer() == null).toList();
		model.addAttribute("found", products);
		return "foundProducts";
	}

	@PostMapping("/uploaded_product")
	public String uploadedProduct(Model model, @RequestParam String title, @RequestParam MultipartFile image, @RequestParam String description, @RequestParam double price) throws IOException {
		String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
		if (title == null || title.isEmpty()){
			model.addAttribute("error", "El título del producto no puede estar vacío");
			return "uploadProduct";
		}
		Product newprod = new Product(title, description, price, null, user);
		productService.save(newprod, image);
		return "uploadedProduct";
	}

	@GetMapping("/products/{id}/image")
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException, IOException {

		Optional<Product> op = productService.findById(id);

		if(op.isPresent()) {
			Product product = op.get();
			Resource image;
			try {
				image = new InputStreamResource(product.getImg().getBinaryStream());
			} catch (Exception e) {
				ClassPathResource resource = new ClassPathResource("static/noPicture.jpg");
        		byte[] imageBytes = resource.getInputStream().readAllBytes();
				return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(imageBytes);
			}
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(image);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pic not found");
		}
	}

	@GetMapping("/buy_product")
	public String buyProduct(Model model, @RequestParam long id, HttpSession session) {
		User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
		Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		product.setBuyer(user);
		productService.save(product);
		session.setAttribute("lastBoughtProduct", product);
		return "boughtProduct";
	}
	
}
