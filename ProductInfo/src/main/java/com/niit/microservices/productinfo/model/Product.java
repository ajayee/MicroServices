package com.niit.microservices.productinfo.model;

public class Product {

	private int Id;
	private Item item;

	public int getId() {
		return Id;
		
	}

	public void setId(int id) {
		this.Id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}