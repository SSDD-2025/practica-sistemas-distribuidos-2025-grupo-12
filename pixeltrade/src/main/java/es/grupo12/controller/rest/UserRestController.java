package es.grupo12.controller.rest;


import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return userService.getLoggedUser();
	}

    @GetMapping("/")
	public Page<UserDTO> getUsers(Pageable pageable) {
		return userService.findAll(pageable).map(this::toDTO);
	}

    @GetMapping("/{id}")
	public UserDTO getUser(@PathVariable long id) {
        return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

	@PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        userDTO = userService.createUser(userDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.id()).toUri();
        return ResponseEntity.created(location).body(userDTO);
    }

    @GetMapping("/{id}/shared-messages")
    public Collection<UserDTO> getSharedMessages(@PathVariable long id){

        /*UserDTO loggedUser = userService.getLoggedUser();
        if (!loggedUser.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }*/
        return userService.findUsersBySharedMessages(id);
    }

    private UserDTO toDTO(User user){
		return mapper.toDTO(user);
	}
}
