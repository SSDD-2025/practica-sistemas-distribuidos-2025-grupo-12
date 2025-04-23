package es.grupo12.controller.rest;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.grupo12.dto.ReviewDTO;
import es.grupo12.dto.ReviewMapper;
import es.grupo12.model.Review;
import es.grupo12.service.ReviewService;
import es.grupo12.service.UserService;

@RestController
@RequestMapping("api/reviews")
public class ReviewRestController {
    
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewMapper mapper;

    @GetMapping("/")
	public Page<ReviewDTO> getReviews(Pageable pageable) {
		return reviewService.findAll(pageable).map(this::toDTO);
	}

    @GetMapping("/{id}")
	public ReviewDTO getReview(@PathVariable long id) {
        return reviewService.getReview(id);
	}

    @PostMapping("/")
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        if (!reviewDTO.author().id().equals(userService.getLoggedUser().id())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        reviewDTO = reviewService.createReview(reviewDTO);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(reviewDTO.id()).toUri();
        return ResponseEntity.created(location).body(reviewDTO);
    }

    @DeleteMapping("/{id}")
    public ReviewDTO deleteReview(@PathVariable long id) {
        return reviewService.deleteReview(id);
    }

    private ReviewDTO toDTO(Review review){
		return mapper.toDTO(review);
	}
}
