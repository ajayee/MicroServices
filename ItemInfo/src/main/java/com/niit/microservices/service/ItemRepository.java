package com.niit.microservices.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.microservices.data.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>, ItemRepositoryCustom{

	Item getByItemID(Integer id);
	
	void addItem(Item item);
}