package es.grupo12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.grupo12.model.Product;
import es.grupo12.model.Review;
import es.grupo12.model.User;
import es.grupo12.service.ReviewService;
import es.grupo12.service.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ReviewWebController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

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
	public String showProducts(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
		model.addAttribute("reviews", reviewService.findBySeller(user));
		return "reviews";
	}
    
}