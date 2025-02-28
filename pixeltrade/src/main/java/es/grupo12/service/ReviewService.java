package es.grupo12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.grupo12.model.Review;
import es.grupo12.model.User;
import es.grupo12.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService userService;

    public Optional<Review> findById(long id) {
		  return reviewRepository.findById(id);
    }

    

    public void save(Review review,User author ,User userToReview) {
      review.setSeller(userToReview);
      review.setAuthor(author); 
      // userToReview.getReceivedReviews().add(review);
      // author.getSentReviews().add(review);
      reviewRepository.save(review);
    }

    // public void delete(Long reviewId, User user) {
    //   Review review = this.findById(reviewId).get();
    //   user.getReceivedReviews().remove(review);

    //   reviewRepository.delete(review);		
    // }



    public List<Review> findBySeller(User user) {
        return reviewRepository.findBySeller(user);
    }
  

	}


