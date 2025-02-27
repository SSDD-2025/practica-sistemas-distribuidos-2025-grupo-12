package es.grupo12.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.grupo12.model.Message;
import es.grupo12.model.Product;
import es.grupo12.model.User;
import es.grupo12.service.MessageService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MessageWebController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/chat")
    public String getChats(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        List<Message> received = messageService.findByReceiver(user);
        List<Message> sent = messageService.findBySender(user);

        Set<User> users = new HashSet<>();
        for (Message msg : received) {
           users.add(msg.getSender()); 
        }
        for (Message msg : sent) {
            users.add(msg.getReceiver()); 
        }

        model.addAttribute("chats", users);


        return "chat";
    }

    @PostMapping("/send_message")
    public String sendMessage(Model model, @RequestParam String text, @RequestParam Long idsender, @RequestParam Long idreceiver) {

        User sender = userService.findById(idsender).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User receiver = userService.findById(idreceiver).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Message message = new Message(text, sender, receiver);
        messageService.save(message);
        
        return "/";
    }
    
    
    
}
