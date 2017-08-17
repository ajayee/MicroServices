package com.niit.microservices.productinfo.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.niit.microservices.productinfo.model.Review;

public class Item {

	private Integer itemID;

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	private String modelNumber;

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	private boolean batteriesRequired;

	public boolean isBatteriesRequired() {
		return batteriesRequired;
	}

	public void setBatteriesRequired(boolean batteriesRequired) {
		this.batteriesRequired = batteriesRequired;
	}

	private Integer weight;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	private Date manufacturingDate;

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	private List<Review> itemReviews = new ArrayList<Review>(0);

	public List<Review> getItemReviews() {
		return itemReviews;
	}

	public void setItemReviews(List<Review> itemReviews) {
		this.itemReviews = itemReviews;
	}
}