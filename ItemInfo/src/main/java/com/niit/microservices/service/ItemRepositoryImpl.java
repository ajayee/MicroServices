package com.niit.microservices.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.niit.microservices.data.Item;

public class ItemRepositoryImpl implements ItemRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@HystrixCommand(fallbackMethod = "getCachedItem")
	public Item getByItemID(Integer Id) {
		return this.entityManager.find(Item.class,Id);
	}
	
	@Override
	@Transactional
	public void addItem(Item item) {
		System.out.println("Jayee: " + item.getName());
		this.entityManager.persist(item);
	}
	
	public Item getCachedItem(Integer Id) {
		return new Item();
	}
	
}