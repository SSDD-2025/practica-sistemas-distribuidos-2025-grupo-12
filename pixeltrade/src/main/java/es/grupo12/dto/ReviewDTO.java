package es.grupo12.dto;

public record ReviewDTO (
    Long id,
    String message,
    BasicUserDTO author,
    BasicUserDTO seller) {
}