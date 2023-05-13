package com.example.userservice.services;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.ResourceNotFoundException;
import com.example.userservice.external.service.HotelService;
import com.example.userservice.external.service.RatingService;
import com.example.userservice.repositories.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;


    public User saveUser(User user) {
        var uid = UUID.randomUUID().toString();
        user.setUserId(uid);
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {

        var user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        // rating microservice communication
        var ratings = Arrays.asList(ratingService.getRating(userId));

        var ratingList = ratings.stream().peek(rating -> {
            // hotel microservice communication
            var hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }).toList();

        user.setRatings(ratingList);

        return user;
    }
}
