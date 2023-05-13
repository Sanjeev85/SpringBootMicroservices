package com.example.ratingservice.services;

import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    // create rating
    public Rating createRating(Rating rating) {
        return ratingRepository.insert(rating);
    }

    //find rating by id
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

}
