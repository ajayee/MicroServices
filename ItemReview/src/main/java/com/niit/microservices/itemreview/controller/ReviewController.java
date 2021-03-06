package com.niit.microservices.itemreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.itemreview.model.Item;
import com.niit.microservices.itemreview.model.Review;
import com.niit.microservices.itemreview.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// -------------------Get Reviews --------------------
	@RequestMapping(method = RequestMethod.GET, value = "/item/{Id}/reviews")
	public List<Review> getReviews(@PathVariable("Id") int Id) {
		
		System.out.println("Request came here >> " + Id);
		return reviewService.findByItemId(Id);
	}
	
	// -------------------Get Review --------------------
	@RequestMapping(method = RequestMethod.GET, value = "/review/{id}")
	public Review getReview(@PathVariable("id") int Id) {
		
		System.out.println("Request for getReview >> " + Id);
		return reviewService.getReview(Id);
	}
	
	// ------------------- Save Review  ----------------------
	@RequestMapping(method = RequestMethod.POST, value = "/item/{itemId}/review")
	public void addReview(@ModelAttribute("review") Review review,
		      BindingResult result, ModelMap model) {
		System.out.println("Comming here........" + review.getReviewComment());
		System.out.println("Comming here........" + review.getItem().getId());
		reviewService.addReview(review);
	}
	
	// ------------------- Update Review  ----------------------
	@RequestMapping(method = RequestMethod.PUT, value = "/item/{itemId}/review/{Id}")
	public void updateReview(@RequestBody Review review, @PathVariable Integer itemId, @PathVariable Integer Id) {
		
		Item item = new Item();
		item.setId(itemId);
		
		review.setItem(item);
		reviewService.updateReview(review);
	}

	// ------------------- Delete Review  ----------------------
	@RequestMapping(method = RequestMethod.DELETE, value = "/item/{itemId}/review/{Id}")
	public void deleteReview(@PathVariable Integer Id) {
		reviewService.deleteReview(Id);
	}
}