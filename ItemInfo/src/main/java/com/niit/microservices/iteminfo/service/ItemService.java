package com.niit.microservices.iteminfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.microservices.iteminfo.model.Item;
import com.niit.microservices.iteminfo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);

		return items;
	}
	
	public Item getByItemId(int itemId) {
		return itemRepository.findOne(itemId);
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
}