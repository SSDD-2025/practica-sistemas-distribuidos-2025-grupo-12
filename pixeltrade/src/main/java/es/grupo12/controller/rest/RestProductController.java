package es.grupo12.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.grupo12.dto.ProductDTO;
import es.grupo12.model.Product;

@RestController
@RequestMapping("/products")
public class RestProductController {

    private ProductDTO toDTO (Product product) {
        return new ProductDTO(product.getId(), product.getTitle(), product.getDescr(), product.getPrice(),
            product.getImg(), product.getBuyer(), product.getSeller());
    }

    private Product toDomain (ProductDTO postDTO) {
        return new Product(postDTO.title(), postDTO.descr(),
            postDTO.price(), postDTO.buyer(), postDTO.seller());
    }

}
