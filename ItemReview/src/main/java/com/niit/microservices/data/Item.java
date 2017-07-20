package com.niit.microservices.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<Review> itemReviews = new ArrayList<Review>(0);

	public List<Review> getItemReviews() {
		return itemReviews;
	}

	public void setItemReviews(List<Review> itemReviews) {
		this.itemReviews = itemReviews;
	}

}