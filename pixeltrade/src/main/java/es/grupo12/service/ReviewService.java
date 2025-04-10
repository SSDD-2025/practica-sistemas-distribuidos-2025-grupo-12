package es.grupo12.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.grupo12.dto.ReviewDTO;
import es.grupo12.dto.ReviewMapper;
import es.grupo12.model.Review;
import es.grupo12.model.User;
import es.grupo12.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService userService;

    @Autowired
    private ReviewMapper mapper;
	
    private ReviewDTO toDTO (Review review) {
        return mapper.toDTO(review);
    }

    private Review toDomain (ReviewDTO reviewDTO) {
        return mapper.toDomain(reviewDTO);
    }

    private List<ReviewDTO> toDTOs(Collection<Review> reviews){
        return mapper.toDTOs(reviews);
    }

    public Optional<Review> findById(long id) {
		  return reviewRepository.findById(id);
    }

    public void save(Review review,User author ,User userToReview) {
      review.setSeller(userToReview);
      review.setAuthor(author);
      reviewRepository.save(review);
    }

    public List<Review> findBySeller(User user) {
        return reviewRepository.findBySeller(user);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public void deleteById(long id) {
        reviewRepository.deleteById(id);
    }

    public void deleteByAuthor(User user) {
        reviewRepository.deleteByAuthor(user);
    }

    public void deleteBySeller(User user) {
        reviewRepository.deleteBySeller(user);
    }

    public Collection<ReviewDTO> getReviews() {
        return toDTOs(reviewRepository.findAll());
    }

    public ReviewDTO getReview(long id) {
        return toDTO(reviewRepository.findById(id).orElseThrow());
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review = toDomain(reviewDTO);
 		reviewRepository.save(review);
 		return toDTO(review);
    }

    public ReviewDTO deleteReview(long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
 		reviewRepository.deleteById(id);
 		return toDTO(review);
    }
  
}


