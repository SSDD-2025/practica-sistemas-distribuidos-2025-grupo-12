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
      reviewRepository.save(review);
    }

    


    public List<Review> findBySeller(User user) {
        return reviewRepository.findBySeller(user);
    }



    public List<Review> findAll() {
        return reviewRepository.findAll();
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
  

	}


