package com.niit.microservices.itemreview.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.niit.microservices.itemreview.model.Item;

@Entity
@Table(name = "ITEM_REVIEW")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REVIEW_ID")
	private Integer Id;

	@Column(name = "REVIEW_COMMENT")
	private String reviewComment;

	@Column(name = "REVIEW_DATE")
	private Date reviewDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	public Integer getReviewID() {
		return Id;
	}

	public void setReviewID(Integer Id) {
		this.Id = Id;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}