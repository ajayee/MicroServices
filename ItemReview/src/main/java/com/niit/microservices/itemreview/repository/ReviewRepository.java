package com.niit.microservices.itemreview.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.microservices.itemreview.model.Item;
import com.niit.microservices.itemreview.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

	public List<Review> findByItem(Item item);
}