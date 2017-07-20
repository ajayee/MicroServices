package com.niit.microservices.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.data.Item;
import com.niit.microservices.data.Review;
import com.niit.microservices.service.ReviewRepository;

@RestController
public class ReviewServiceController {

	@Autowired
	private ReviewRepository reviewRepository;

	// -------------------Retrieve Reviews --------------------
	@RequestMapping(method = RequestMethod.GET, value = "item/{id}")
	public List<Review> getReviews(@PathVariable("id") int id) {
		System.out.println("Request came here >> " + id);

		Item item = new Item();
		item.setItemID(id);
		
		List<Review> reviews = (List<Review>)reviewRepository.findReviewsByItem(item);
		System.out.println("Number of reviews received: " + reviews.size());

		for (Review review : reviews) {
			review.setItem(null);
		}
		
		return reviews;
	}
	
	// ------------------- Save Review  ----------------------
	@RequestMapping(method = RequestMethod.POST, value = "addReview")
	public void addReview(@ModelAttribute("review") Review review,
		      BindingResult result, ModelMap model) {
		System.out.println("Comming here........" + review.getReviewComment());
		System.out.println("Comming here........" + review.getItem().getItemID());
		reviewRepository.save(review);
	}
}