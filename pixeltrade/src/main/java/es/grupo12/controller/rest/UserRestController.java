package es.grupo12.controller.rest;


import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.grupo12.dto.UserDTO;
import es.grupo12.dto.UserMapper;
import es.grupo12.model.User;
import es.grupo12.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;
    
    @GetMapping("/me")
	public UserDTO me() {
		return userService.getLoggedUserDTO();
	}

    @GetMapping("/")
	public Page<UserDTO> getUsers(Pageable pageable) {
        UserDTO loggedUserDTO = userService.getLoggedUserDTO();
        if (loggedUserDTO.id() != 1) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
		return userService.findAll(pageable).map(this::toDTO);
	}

    @GetMapping("/{id}")
	public UserDTO getUser(@PathVariable long id) {
        UserDTO loggedUserDTO = userService.getLoggedUserDTO();
        if (!loggedUserDTO.id().equals(id) && loggedUserDTO.id() != 1) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable long id) {
        UserDTO deletedUser = userService.getUser(id);
        if (!deletedUser.id().equals(userService.getLoggedUserDTO().id()) && userService.getLoggedUserDTO().id() != 1){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        userService.deleteById(id);
        return deletedUser;
    }

	@PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            User loggedUser = userService.getLoggedUser();
            if (loggedUser.getId() != 1){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException ex) {
            
        }
        userDTO = userService.createUser(userDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.id()).toUri();
        return ResponseEntity.created(location).body(userDTO);
    }

    @GetMapping("/{id}/shared-messages")
    public Collection<UserDTO> getSharedMessages(@PathVariable long id){

        UserDTO loggedUser = userService.getLoggedUserDTO();
        if (!loggedUser.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return userService.findUsersBySharedMessages(id);
    }

    private UserDTO toDTO(User user){
		return mapper.toDTO(user);
	}
}
