package com.niit.microservices.productinfo.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private int Id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	private List<Item> item = new ArrayList<Item>(0);

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
}