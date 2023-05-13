package com.example.userservice.external.service;

import com.example.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/ratings/user/{userId}")
    public Rating[] getRating(@PathVariable("userId") String id);
}
