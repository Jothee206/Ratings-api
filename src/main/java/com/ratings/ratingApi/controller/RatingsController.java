package com.ratings.ratingApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.ratingApi.dao.RatingsRepository;
import com.ratings.ratingApi.dto.MessageDTO;
import com.ratings.ratingApi.model.Ratings;
import com.ratings.ratingApi.service.RatingsService;

@RestController
public class RatingsController {
	@Autowired
	RatingsRepository ratingsRepository;
	
	@Autowired
	RatingsService ratingsService;
	
	@PostMapping("ratings/save") 
	public ResponseEntity  <?> save(@RequestBody Ratings ratings){
		System.out.println(ratings);
		try {
			ratingsService.save(ratings);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>( message,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("ratings/list")
	public List<Ratings> displayRatings() {
		List<Ratings> findAll = null;
		try {
			findAll = ratingsService.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return findAll;

	}
	@GetMapping("ratings/{id}")
	public Ratings get(@PathVariable("id") Integer id) {
		return ratingsService.findById(id);
	}
	@DeleteMapping("ratings/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		
			try {
				ratingsService.deleteById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}



