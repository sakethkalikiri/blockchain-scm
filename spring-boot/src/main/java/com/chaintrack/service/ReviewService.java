package com.chaintrack.service;

import java.util.List;

import com.chaintrack.exception.ProductException;
import com.chaintrack.modal.Review;
import com.chaintrack.modal.User;
import com.chaintrack.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
