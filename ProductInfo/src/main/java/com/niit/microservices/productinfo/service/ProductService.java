package com.niit.microservices.productinfo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.microservices.productinfo.client.ItemInfoClient;
import com.niit.microservices.productinfo.client.ItemReviewClient;
import com.niit.microservices.productinfo.model.Item;
import com.niit.microservices.productinfo.model.Product;

@Service
public class ProductService {

	@Autowired
	ItemInfoClient itemInfoClient;

	@Autowired
	ItemReviewClient itemReviewClient;
	
	public Product getProduct(int id) {

		// Using Feign client to get the Item
		String itemInfoJson = itemInfoClient.getItemInfo(id);
		// Using Feign client to get the Item
				String itemReviewJson = itemReviewClient.getItemReview(id);
				
		ObjectMapper mapper = new ObjectMapper();
		Item item = null;
		Product product = null;

		try {

			item = mapper.readValue(itemInfoJson, Item.class);

			product = new Product();
			product.setItem(item);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return product;
	}
}