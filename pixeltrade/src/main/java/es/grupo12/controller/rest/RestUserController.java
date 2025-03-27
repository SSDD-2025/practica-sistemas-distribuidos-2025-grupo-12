package es.grupo12.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.grupo12.dto.UserDTO;
import es.grupo12.model.User;

@RestController
@RequestMapping("/users")
public class RestUserController {
    private UserDTO toDTO (User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getMail(), user.getPassword(),
            user.getProducts(), user.getSentReviews(), user.getReceivedReviews(), user.getSentMessages(), 
            user.getReceivedMessages(), user.getRoles());
    }

    private User toDomain (UserDTO userDTO) {
        return new User(userDTO.username(), userDTO.mail(),
            userDTO.password(), userDTO.roles());
    }
}
