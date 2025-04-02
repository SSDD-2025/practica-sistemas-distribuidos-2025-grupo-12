package es.grupo12.dto;

import java.util.List;

public record UserDTO (
    Long id,
    String username,
	String mail,
    String password,
    List<String> roles) {
}