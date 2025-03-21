package es.grupo12.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.grupo12.model.Product;
import es.grupo12.model.Review;
import es.grupo12.model.User;
import es.grupo12.service.ReviewService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ReviewWebController {

    @Autowired
    ReviewService reviewService;

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

    @PostMapping("/write_review")
    public String writeReview(Model model, HttpSession session, @RequestParam String message) {
        Review review = new Review(message,null,null);
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        Product lastProduct = (Product) session.getAttribute("lastBoughtProduct");
        User seller = lastProduct.getSeller();
        reviewService.save(review,user,seller);
        return "redirect:/products";
    }

    
	@GetMapping("/reviews")
	public String showMyReviews(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
		model.addAttribute("reviews", reviewService.findBySeller(user));
		return "reviews";
	}

    @GetMapping("/allReviews")
    public String showReviews(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Review> allReviews = reviewService.findAll();
        model.addAttribute("reviews", allReviews);
        model.addAttribute("user", user);
        return "allReviews"; 
    }

    @PostMapping("/delete_review")
	public String deleteUser(@RequestParam String id) throws IOException {
        long iden = Long.parseLong(id);
		reviewService.deleteById(iden);

    	return "redirect:/allReviews"; 
	}

    @GetMapping("/user_reviews")
	public String userReviews(Model model, @RequestParam long id, HttpSession session) {
		User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        User account = userService.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("contact", account);
		model.addAttribute("reviews", reviewService.findBySeller(account));
		return "userReviews";
	}
}