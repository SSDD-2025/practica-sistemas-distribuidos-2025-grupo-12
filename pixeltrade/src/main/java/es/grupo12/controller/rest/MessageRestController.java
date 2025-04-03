package es.grupo12.controller.rest;


import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.grupo12.dto.MessageDTO;
import es.grupo12.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
	public Collection<MessageDTO> getMessages() {
		return messageService.getMessages();
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
    public ResponseEntity<MessageDTO> createProduct(@RequestBody MessageDTO messageDTO) {
        messageDTO = messageService.createMessage(messageDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(messageDTO.id()).toUri();
        return ResponseEntity.created(location).body(messageDTO);
    }
}
