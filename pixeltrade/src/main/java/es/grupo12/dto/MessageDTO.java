package es.grupo12.dto;

import java.time.LocalDateTime;

public record MessageDTO (
    Long id,
    String text,
	LocalDateTime date,
    BasicUserDTO sender,
    BasicUserDTO receiver) {
}
