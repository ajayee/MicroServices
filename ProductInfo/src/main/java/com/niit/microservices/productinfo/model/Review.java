package com.niit.microservices.productinfo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

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
}
