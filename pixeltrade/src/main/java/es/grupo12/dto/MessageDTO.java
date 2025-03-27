package es.grupo12.dto;

import java.time.LocalDateTime;

import es.grupo12.model.User;

public record MessageDTO (
    Long id,
    String text,
	LocalDateTime date,
    User sender,
    User receiver) {
}
