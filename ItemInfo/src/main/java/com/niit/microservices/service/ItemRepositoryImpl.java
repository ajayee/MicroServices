package com.niit.microservices.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.niit.microservices.data.Item;

public class ItemRepositoryImpl implements ItemRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Item getByItemID(Integer Id) {
		return this.entityManager.find(Item.class,Id);
	}
}