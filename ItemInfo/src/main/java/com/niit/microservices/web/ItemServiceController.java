package com.niit.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.data.Item;
import com.niit.microservices.service.ItemRepositoryCustom;

@RestController
public class ItemServiceController {

	@Autowired
	private ItemRepositoryCustom itemRepository;

	// ------------------- Retrieve Item ----------------------
	@RequestMapping(method = RequestMethod.GET, value = "item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable("id") int id) {
		System.out.println("Request for item ID >> " + id);	

		Item item = itemRepository.getByItemID(id);
		System.out.println("Item retrieved >> " + item.getName());

		if (item.getName().trim().length() <= 0) {
			return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	// ------------------- Save Item ----------------------
	@RequestMapping(method = RequestMethod.POST, value = "addItem")
	public void addItem(@ModelAttribute("item") Item item,
		      BindingResult result, ModelMap model) {
		itemRepository.addItem(item);
	}
}