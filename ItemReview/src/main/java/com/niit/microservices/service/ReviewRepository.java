package com.niit.microservices.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.microservices.data.Item;
import com.niit.microservices.data.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

	List<Review> findReviewsByItem(Item item);
	
}