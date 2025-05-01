package es.grupo12.dto;

public record ProductDTO (
    Long id,
    String title,
	String descr,
    BasicUserDTO buyer,
    BasicUserDTO seller,
    Double price) {
}
