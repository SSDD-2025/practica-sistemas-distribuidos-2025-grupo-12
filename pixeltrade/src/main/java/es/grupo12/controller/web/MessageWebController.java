package es.grupo12.controller.web;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.grupo12.model.Message;
import es.grupo12.model.User;
import es.grupo12.service.MessageService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MessageWebController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
		} else {
			model.addAttribute("logged", false);
		}
	}

    @GetMapping("/chat_list")
    public String getChats(Model model) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));

        List<Message> received = messageService.findByReceiver(user);
        List<Message> sent = messageService.findBySender(user);

        Set<User> users = new HashSet<>();
        for (Message msg : received) {
            users.add(msg.getSender()); 
        }
        for (Message msg : sent) {
            users.add(msg.getReceiver()); 
        }

        if (users.isEmpty()) {
            return "noChat";
        } else {
            model.addAttribute("chats", users);
            return "chatList";
        }
    }

    @PostMapping("/send_message")
    public String sendMessage(@RequestParam String text, @RequestParam Long idsender, @RequestParam Long idreceiver) {

        User sender = userService.findById(idsender).orElseThrow(() -> new RuntimeException("User not found"));
        User receiver = userService.findById(idreceiver).orElseThrow(() -> new RuntimeException("User not found"));

        LocalDateTime now = LocalDateTime.now();
        Message message = new Message(text, now, sender, receiver);
        messageService.save(message);

        return "redirect:/show_chat?id=" + idreceiver;
    }
    
    @GetMapping("/show_chat")
    public String showChat(Model model, @RequestParam Long id) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);

        User sender = userService.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("contact", sender);

        List<Message> messages = messageService.findMessagesBetweenUsers(sender, user);

        List<AbstractMap.SimpleEntry<Message, Boolean>> messagesList = new ArrayList<>();
        for (Message message : messages) {
            if (message.getSender().getId() == user.getId()) { //if I sent the message true
                AbstractMap.SimpleEntry<Message, Boolean> pair = new AbstractMap.SimpleEntry<>(message, true);
                messagesList.add(pair);
            } else {
                AbstractMap.SimpleEntry<Message, Boolean> pair = new AbstractMap.SimpleEntry<>(message, false);
                messagesList.add(pair);
            }
        }

        model.addAttribute("messages", messagesList);
        return "chat";
    }

    @GetMapping("/messages")
    public String showMessages(Model model) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));

        List<Message> allMessages = messageService.findAll();
        model.addAttribute("messages", allMessages);
        model.addAttribute("user", user);
        return "messages"; 
    }

    @PostMapping("/delete_message")
	public String deleteMessage(@RequestParam String id) throws IOException {
        long iden = Long.parseLong(id);
		messageService.deleteById(iden);

    	return "redirect:/messages"; 
	}
    
}
