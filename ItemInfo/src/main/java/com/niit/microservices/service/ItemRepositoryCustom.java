package com.niit.microservices.service;

import com.niit.microservices.data.Item;

public interface ItemRepositoryCustom {

	Item getByItemID(Integer id);
	
	void addItem(Item item);
}