package es.grupo12.controller.web;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.grupo12.model.User;
import es.grupo12.service.MessageService;
import es.grupo12.service.ProductService;
import es.grupo12.service.ReviewService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class UserWebController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    MessageService messageService;


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

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // Form HTML page
    }

    @PostMapping("/register")
    public String newUser(Model model, User user){
        userService.save(user);
        model.addAttribute("name", user.getUsername());
		return  "saved_user";
	}

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";  // HTML page
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "profile"; 
    }

    @GetMapping("/administration")
    public String showAdministration(Model model) {
        return "administration";  //Revise
    }

    @GetMapping("/users")
    public String showUser(Model model) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);
        model.addAttribute("user", user);
        return "users"; 
    }

    @GetMapping("/personalInfo")
    public String showPersonalInformation(Model model) {
        String userName = (String) model.getAttribute("userName");
        User user = userService.findByUsername(userName).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "personalInfo"; 
    }

    @PostMapping("/delete_user")
	public String deleteUser(@RequestParam String id) throws IOException {
        long iden = Long.parseLong(id);
        userService.deleteById(iden);
    	return "redirect:/users"; 
	}

}
