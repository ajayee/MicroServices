package com.niit.microservices.productinfo.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Benefits to keep the signature of the name and fall back same.
public interface ItemReviewService {

	@RequestMapping("/item/{Id}/reviews")
	public String getItemReviews(@PathVariable("Id") int Id);

}