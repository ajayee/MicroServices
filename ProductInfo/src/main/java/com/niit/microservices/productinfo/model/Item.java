package com.niit.microservices.productinfo.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.niit.microservices.productinfo.model.Review;

@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Integer itemID;

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	@Column(name = "NAME")
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "MODEL_NUM")
	private String modelNumber;
	
	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	@Column(name = "BATTERIES_REQUIRED")
	private boolean batteriesRequired;
	
	public boolean isBatteriesRequired() {
		return batteriesRequired;
	}

	public void setBatteriesRequired(boolean batteriesRequired) {
		this.batteriesRequired = batteriesRequired;
	}

	@Column(name = "WEIGHT")
	private Integer weight;
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "MANUFACTURING_DATE")
	private Date manufacturingDate;

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    @Column(nullable = true)
	private List<Review> itemReviews = new ArrayList<Review>(0);

	public List<Review> getItemReviews() {
		return itemReviews;
	}

	public void setItemReviews(List<Review> itemReviews) {
		this.itemReviews = itemReviews;
	}
}