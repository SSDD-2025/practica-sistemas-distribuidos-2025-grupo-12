package es.grupo12.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.grupo12.model.User;
import es.grupo12.repository.UserRepository;
import es.grupo12.service.UserService;


@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String newUser(Model model, User user){
        
		User newUser = userService.save(user);
        model.addAttribute("name", newUser.getUsername());

		return  "redirect:/saved_user";
	}
    
    
}
