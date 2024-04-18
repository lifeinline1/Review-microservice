package com.jobapp.reviewms.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null){
            return null;
        }
        return review;
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        if(review != null){
            review.setCompanyId(companyId);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review oldReview = reviewRepository.findById(id).orElse(null);
        if(oldReview != null){
            oldReview.setCompanyId(review.getCompanyId());
            oldReview.setTitle(review.getTitle());
            oldReview.setContent(review.getContent());
            oldReview.setAuthor(review.getAuthor());
            return reviewRepository.save(oldReview);
        }

        return null;
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
