package es.grupo12.controller.rest;


import java.util.Collection;
import java.util.List;

// import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import es.grupo12.dto.UserDTO;
import es.grupo12.dto.UserMapper;

import es.grupo12.model.User;
import es.grupo12.service.UserService;

@RestController
@RequestMapping("/users")
public class RestUserController {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService userService;
    

    private UserDTO toDTO (User user) {
        return mapper.toDTO(user);
    }

    private User toDomain (UserDTO userDTO) {
        return mapper.toDomain(userDTO);
    }

    private List<UserDTO> toDTOs(Collection<User> users){
        return mapper.toDTOs(users);
    }

    @GetMapping("/me")
	public UserDTO me() {
		return toDTO(userService.getLoggedUser());
	}


}
