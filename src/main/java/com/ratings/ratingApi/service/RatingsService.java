package com.ratings.ratingApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ratings.ratingApi.dao.OverallRatingRepository;
import com.ratings.ratingApi.dao.RatingsRepository;
import com.ratings.ratingApi.model.OverallRating;
import com.ratings.ratingApi.model.Ratings;


@Service
public class RatingsService {
	@Autowired
	RatingsRepository ratingsRepository;
	
	public void save(Ratings ratings) throws Exception {
		try {

			ratingsRepository.save(ratings);
			int count=ratingsRepository.getAllRatings(ratings.getProductId());
			int sum=ratingsRepository.getSumOfRatings(ratings.getProductId());
			int rating=sum/count;
			OverallRatingRepository.updateProductRating(ratings,ratings.getProductId());
			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Ratings> findAll() throws Exception {
		List<Ratings> listRatings = null;
		try {
			listRatings = ratingsRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listRatings;

	}

	public void deleteById(Integer id) throws Exception {
		try {
			ratingsRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Ratings findById(Integer id) {
		Optional<Ratings> ratings = ratingsRepository.findById(id);
		if (ratings.isPresent()) {
			return ratings.get();
		} else {
			return null;
		}
	}
	
   
}