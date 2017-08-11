package com.niit.microservices.itemreview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.microservices.itemreview.model.Review;
import com.niit.microservices.itemreview.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public List<Review> findBy(int Id) {
		
		List<Review> reviews = new ArrayList<>();
		reviewRepository.getByItem(Id).forEach(reviews::add);;

		return reviews;
	}
	
	public void addReview(Review review) {
		reviewRepository.save(review);
	}

	public void updateReview(Review review) {
		reviewRepository.save(review);
	}
	
	public void deleteReview(Integer Id) {
		reviewRepository.delete(Id);
	}
}