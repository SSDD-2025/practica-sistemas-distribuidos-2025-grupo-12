package es.grupo12.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.grupo12.model.User;
import es.grupo12.repository.UserRepository;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // Página HTML del formulario
    }
    @PostMapping("/register")
    public String newUser(Model model, User user){
        
		User newUser = userService.save(user);
        model.addAttribute("name", newUser.getUsername());

		return  "saved_user";
	}

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";  // Página HTML del formulario
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, 
                            @RequestParam String password, 
                            HttpSession session, Model model) {
        List<User> users = userService.findByUsername(username);
        User user = users.get(0);
        
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user); // Guarda el usuario en sesión
            model.addAttribute("name", user.getUsername());
            return "logged_user";  // Página de bienvenida
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
    
}
