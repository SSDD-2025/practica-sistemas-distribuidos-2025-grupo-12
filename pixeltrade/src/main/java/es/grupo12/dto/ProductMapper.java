package es.grupo12.dto;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import es.grupo12.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOs(Collection<Product> products);
    Product toDomain(ProductDTO postDTO);
}
