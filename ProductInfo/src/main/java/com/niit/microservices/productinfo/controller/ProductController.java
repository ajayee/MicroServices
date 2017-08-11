package com.niit.microservices.productinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.productinfo.model.Product;
import com.niit.microservices.productinfo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "/product/{itemId}", produces = "application/json")
	public Product getProduct(@PathVariable Integer itemId) {
		
		return this.productService.getProduct(itemId);
	}
}