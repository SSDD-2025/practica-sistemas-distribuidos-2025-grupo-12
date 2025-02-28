package es.grupo12.controller;

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
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.joran.sanity.Pair;



@Controller
public class MessageWebController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/chat_list")
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

        if (users.isEmpty()) {
            return "noChat";
        } else {
            model.addAttribute("chats", users);
            return "chatList";
        }
    }

    @PostMapping("/send_message")
    public String sendMessage(Model model, @RequestParam String text, @RequestParam Long idsender, @RequestParam Long idreceiver) {

        User sender = userService.findById(idsender).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User receiver = userService.findById(idreceiver).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        LocalDateTime now = LocalDateTime.now();
        Message message = new Message(text, now, sender, receiver);
        messageService.save(message);
        
        return "/";
    }
    
    @PostMapping("/show_chat")
    public String showChat(Model model, @RequestParam Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        User sender = userService.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
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
    
}
