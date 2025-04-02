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

import es.grupo12.dto.ReviewDTO;
import es.grupo12.service.ReviewService;

@RestController
@RequestMapping("api/reviews")
public class ReviewRestController {
    
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
	public Collection<ReviewDTO> getReviews() {
		return reviewService.getReviews();
	}

    @GetMapping("/{id}")
	public ReviewDTO getReview(@PathVariable long id) {
        return reviewService.getReview(id);
	}

    @PostMapping("/")
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        reviewDTO = reviewService.createReview(reviewDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(reviewDTO.id()).toUri();
        return ResponseEntity.created(location).body(reviewDTO);
    }

    @DeleteMapping("/{id}")
    public ReviewDTO deleteReview(@PathVariable long id) {
        return reviewService.deleteReview(id);
    }
}
