package es.dto;

import es.grupo12.model.User;

public record ReviewDTO (
    Long id,
    String message,
    User author,
    User seller) {
}