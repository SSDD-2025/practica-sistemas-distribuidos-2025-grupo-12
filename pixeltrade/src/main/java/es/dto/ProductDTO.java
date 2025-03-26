package es.dto;

import java.sql.Blob;

import es.grupo12.model.User;

public record ProductDTO (
    Long id,
    String title,
	String descr,
    Double price,
    Blob img,
    User buyer,
	User seller) {
}
