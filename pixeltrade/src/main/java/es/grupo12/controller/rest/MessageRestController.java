package es.grupo12.controller.rest;


import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

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

import es.grupo12.dto.MessageDTO;
import es.grupo12.dto.MessageMapper;
import es.grupo12.dto.UserDTO;
import es.grupo12.model.Message;
import es.grupo12.model.User;
import es.grupo12.service.MessageService;
import es.grupo12.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageMapper mapper;

    @GetMapping("/")
	public Page<MessageDTO> getMessages(Pageable pageable) {
		return messageService.findAll(pageable).map(this::toDTO);
	}

    @GetMapping("/{id}")
	public MessageDTO getMessage(@PathVariable long id) {
        return messageService.getMessage(id);
	}

	@DeleteMapping("/{id}")
    public MessageDTO deleteMessage(@PathVariable long id) {
        return messageService.deleteMessage(id);
    }

	@PostMapping("/")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        messageDTO = messageService.createMessage(messageDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(messageDTO.id()).toUri();
        return ResponseEntity.created(location).body(messageDTO);
    }

    @GetMapping ("/users/{id1}/{id2}")
    public Collection<MessageDTO> getConversation(@PathVariable long id1, @PathVariable long id2){
        UserDTO loggedUser = userService.getLoggedUser();
        if (!loggedUser.id().equals(id1) && !loggedUser.id().equals(id2)) {
             throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        User user1 = userService.findById(id1).orElseThrow();
        User user2 = userService.findById(id2).orElseThrow();
        return messageService.getConversations(user1,user2);
    }

    private MessageDTO toDTO(Message message){
		return mapper.toDTO(message);
	}
}