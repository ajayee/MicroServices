package com.niit.microservices.productinfo.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.microservices.productinfo.client.ItemInfoClient;
import com.niit.microservices.productinfo.client.ItemReviewClient;
import com.niit.microservices.productinfo.model.Item;
import com.niit.microservices.productinfo.model.Product;
import com.niit.microservices.productinfo.model.Review;

@Service
public class ProductService {

	@Autowired
	ItemInfoClient itemInfoClient;

	@Autowired
	ItemReviewClient itemReviewClient;
	
	public Product getProduct(int id) {

		// Using Feign client to get the Item
		String itemInfoJson = itemInfoClient.getItemInfo(id);
		
		// Using Feign client to get an Item's Review
		String itemReviewJson = itemReviewClient.getItemReviews(id);
				
		ObjectMapper mapper = new ObjectMapper();
		Item[] item = null;
		Review[] review = null;
		Product product = null;

		try {

			item = mapper.readValue(itemInfoJson, Item[].class);
			System.out.println("itemReviewJson: " + itemReviewJson);
			
			review = mapper.readValue(itemReviewJson, Review[].class);
			item[0].setItemReviews(Arrays.asList(review)); // We will always one product with one ID.
			
			product = new Product();
			product.setItem(Arrays.asList(item));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return product;
	}
	
	public Product getProducts() {

		// Using Feign client to get the Item
		String itemInfoJson = itemInfoClient.getItems();
		
		// Using Feign client to get an Item's Review
		String itemReviewJson = null;
				
		ObjectMapper mapper = new ObjectMapper();
		Review[] review = null;
		Product product = null;

		try {
			
			Item[] items = mapper.readValue(itemInfoJson, Item[].class);
		    
		    for (Item item: items) {
		    	
		    	itemReviewJson = itemReviewClient.getItemReviews(item.getItemID());
		    	
		    	review = mapper.readValue(itemReviewJson, Review[].class);
		    	item.setItemReviews(Arrays.asList(review));
		    } 

			product = new Product();
			product.setItem(Arrays.asList(items));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return product;
	}
}