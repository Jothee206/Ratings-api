package com.ratings.ratingApi.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ratings.ratingApi.model.OverallRating;
import com.ratings.ratingApi.model.Ratings;


public interface OverallRatingRepository extends JpaRepository<OverallRating, Integer> {

	@Transactional
	@Modifying
	@Query("update com.ratings.ratingApi.model.OverallRating u set u.rating=:rating where u.productId=:productId")
	public static void updateProductRating(@Param("rating") Ratings ratings,@Param("productId") int productId) {
		
	}
}
