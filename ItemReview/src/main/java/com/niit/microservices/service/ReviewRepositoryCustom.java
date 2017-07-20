package com.niit.microservices.service;

import java.util.List;

import com.niit.microservices.data.Item;
import com.niit.microservices.data.Review;

public interface ReviewRepositoryCustom {

	List<Review> findReviewsByItem(Item item);
}