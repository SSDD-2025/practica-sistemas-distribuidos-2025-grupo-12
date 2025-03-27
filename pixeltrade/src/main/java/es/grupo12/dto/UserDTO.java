package es.grupo12.dto;

import java.util.List;

import es.grupo12.model.Message;
import es.grupo12.model.Product;
import es.grupo12.model.Review;

public record UserDTO (
    Long id,
    String username,
	String mail,
    String password,
    List<Product> products,
    List<Review> sentReviews,
	List<Review> receivedReviews,
    List<Message> sentMessages,
    List<Message> receivedMessages,
    List<String> roles) {
}