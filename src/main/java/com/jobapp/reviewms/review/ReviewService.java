package com.jobapp.reviewms.review;

import java.util.List;


public interface ReviewService {

    List<Review> getReviews();
    Review getReview(Long id);
    Review addReview(Long companyId, Review review);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);

}
