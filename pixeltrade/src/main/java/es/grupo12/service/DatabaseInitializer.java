package es.grupo12.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.grupo12.model.Product;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private ProductService productService;

    @PostConstruct
    public void init() throws IOException {
        // Create some shops
        Product juego1 = new Product("Uncharted", "Juego mega epico", 29, "hola");
		Product juego2 = new Product("Otro juego", "Juego epicardo ricardo", 219, "hoola");
        Product juego3 = new Product("Otro juego3", "Juego epicardo ricardo3", 219, "hoola");
        Product juego4 = new Product("Otro juego4", "Juego epicardo ricardo4", 219, "hoola");

        productService.save(juego1);
        productService.save(juego2);
        productService.save(juego3);
        productService.save(juego4);
    }
        

}
