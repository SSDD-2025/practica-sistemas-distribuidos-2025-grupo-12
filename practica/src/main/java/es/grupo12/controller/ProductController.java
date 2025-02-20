package es.grupo12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.grupo12.model.Product;


@Controller
public class ProductController {
	
    
	private List<Product> products = new ArrayList<>();

    public void init() {
		products.add(new Product("Consola NextGen","Experimenta gráficos de última generación.", 399.99, "", null, null ));
        products.add(new Product("Consola N","Experimenta gráficos de última generación.", 335.99, "", null, null ));
        products.add(new Product("Consola Gen","Experimenta gr de última generación.", 33.99, "", null, null ));

	}

	@GetMapping("/")
	public String showProducts(Model model) {
		model.addAttribute("products", products);
		return "index";
	}
	
}