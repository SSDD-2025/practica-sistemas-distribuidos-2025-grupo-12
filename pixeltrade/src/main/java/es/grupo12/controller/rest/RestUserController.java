package es.grupo12.controller.rest;


import java.util.Collection;

// import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.grupo12.dto.UserDTO;
import es.grupo12.service.UserService;

@RestController
@RequestMapping("/api/users")
public class RestUserController {

    

    @Autowired
    private UserService userService;
    

    @GetMapping("/me")
	public UserDTO me() {
		return userService.getLoggedUser();
	}

    @GetMapping("/")
	public Collection<UserDTO> getUsers() {
		return userService.getUsers();
	}

    @GetMapping("/{id}")
	public UserDTO getUser(@PathVariable long id) {
        return userService.getUser(id);
	}


}
