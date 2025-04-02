package es.grupo12.dto;

public record ReviewDTO (
    Long id,
    String message,
    UserDTO author,
    UserDTO seller) {
}