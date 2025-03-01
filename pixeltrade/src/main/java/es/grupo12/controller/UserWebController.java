package es.grupo12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "register";  // Form HTML page
    }

    @PostMapping("/register")
    public String newUser(Model model, User user){
        User newUser = userService.save(user);
        model.addAttribute("name", newUser.getUsername());
		return  "saved_user";
	}

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";  // HTML page
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, 
                            @RequestParam String password, 
                            HttpSession session, Model model) {
        List<User> users = userService.findByUsername(username);
        User user = users.get(0);
        
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user); // Save user in http sesion
            model.addAttribute("name", user.getUsername());
            return "logged_user";  // Welcome page
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/";
    }

    @GetMapping("/profile")
    public String showProfile(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "profile"; 
    }
    @GetMapping("/personalInfo")
    public String showPersonalInformation(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "personalInfo"; 
    }

}
