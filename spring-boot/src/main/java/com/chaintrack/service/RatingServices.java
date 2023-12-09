package com.chaintrack.service;

import java.util.List;

import com.chaintrack.exception.ProductException;
import com.chaintrack.modal.Rating;
import com.chaintrack.modal.User;
import com.chaintrack.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
