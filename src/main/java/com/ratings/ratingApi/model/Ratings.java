package com.ratings.ratingApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ratings")
public class Ratings{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private Integer id;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="ratings")
	private Integer ratings;
	
	@Column(name="review")
	private String review;

	
	
}

