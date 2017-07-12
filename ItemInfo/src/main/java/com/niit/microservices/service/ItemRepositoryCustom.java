package com.niit.microservices.service;

import com.niit.microservices.data.Item;

public interface ItemRepositoryCustom {

	public Item getByItemID(Integer id);
}
