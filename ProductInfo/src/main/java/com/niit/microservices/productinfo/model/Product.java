package com.niit.microservices.productinfo.model;

public class Product {

	private int Id;
	private Item item;
	private Review review;

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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}