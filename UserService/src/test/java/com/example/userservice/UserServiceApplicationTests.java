package com.example.userservice;

import com.example.userservice.entities.Rating;
import com.example.userservice.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RatingService ratingService;

    @Test
    void createRating() {
        var rating = Rating.builder().rating(10).userId("").hotelId("").feedback("feedback form user").build();
        var savedRating = ratingService.createRating(rating);
        System.out.println("newly created rating");
    }
}
