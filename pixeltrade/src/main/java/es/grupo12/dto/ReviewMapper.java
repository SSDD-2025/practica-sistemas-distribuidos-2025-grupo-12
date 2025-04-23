package es.grupo12.dto;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import es.grupo12.model.Review;


@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDTO(Review review);

    List<ReviewDTO> toDTOs(Collection<Review> reviews);

    Review toDomain(ReviewDTO reviewDTO);
    
}
