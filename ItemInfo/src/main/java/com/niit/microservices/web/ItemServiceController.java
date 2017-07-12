package com.niit.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.service.ItemService;

@RestController
public class ItemServiceController {

	@Autowired
	ItemService itemService;

	// ------------------- Retrieve Item ------------------------------
	@RequestMapping(method = RequestMethod.GET, value = "/item/{id}")
	public String getItem(@PathVariable("id") int id) throws Exception {

		System.out.println("Request came here >> " + id);
		return itemService.getItem(id);
	}
}