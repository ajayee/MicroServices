package com.niit.microservices.itemreview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.microservices.itemreview.model.Item;
import com.niit.microservices.itemreview.model.Review;
import com.niit.microservices.itemreview.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public List<Review> findByItemId(Integer Id) {
		
		List<Review> reviews = new ArrayList<>();
		
		Item item = new Item();
		item.setId(Id);
		
		reviewRepository.findByItem(item).forEach(reviews::add);
		return reviews;
	}
	
	public Review getReview(Integer Id){
		
		Review review = reviewRepository.findOne(Id);
		System.out.println(review.getReviewComment());
		return review;
		
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