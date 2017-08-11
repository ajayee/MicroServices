package com.niit.microservices.iteminfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.iteminfo.model.Item;
import com.niit.microservices.iteminfo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	// ------------------- Retrieve Item ----------------------
	@RequestMapping("items/{id}")
	public ResponseEntity<Item> getIemById(@PathVariable("id") int id) {

		System.out.println("Request for item ID >> " + id);

		Item item = itemService.getByItemId(id);
		System.out.println("Item retrieved >> " + item.getName());

		if (item.getName().trim().length() <= 0) {
			return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}

	// ------------------- Retrieve Item ----------------------
	@RequestMapping("/items")
	public List<Item> getAllItems() {

		List<Item> items = itemService.getAllItems();
		System.out.println("Number of Items retrieved >> " + items.size());

		return items;
	}

	/*
	// ------------------- Save Item ----------------------
	@RequestMapping(method = RequestMethod.POST, consumes = { "application/x-www-form-urlencoded" }, value = "/items")
	public @ResponseBody void addItem(@RequestBody MultiValueMap params) {
		// System.out.println("Yes here... " + item.getName());
		// itemService.addItem(item);
		System.out.println("params are " + params);
	}
	*/

	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public void addItem(@ModelAttribute("item") Item item, BindingResult result, ModelMap model) {
		itemService.addItem(item);
	}
}
