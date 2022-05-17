package com.ratings.ratingApi.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ratings.ratingApi.model.Ratings;


public interface RatingsRepository extends JpaRepository<Ratings,Integer>{

	void save(Integer ratings);
	
	@Query("select count(ratings) from com.ratings.ratingApi.model.Ratings u where u.productId=:productId")
	int getAllRatings(@Param("productId") int productId);
	
	@Query("select sum(ratings) from com.ratings.ratingApi.model.Ratings u where u.productId=:productId")
	int getSumOfRatings(@Param("productId") int productId);

	
}