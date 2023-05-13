package com.example.userservice.services;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.ResourceNotFoundException;
import com.example.userservice.repositories.UserRepository;
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
        // fetch user rating
        // localhost:8083/ratings/user/9f6b23d5-5a6d-4779-952b-8f5dce7396b9
        var url = "http://RATING-SERVICE/ratings/user/" + userId;
        var ratingOfUser = restTemplate.getForObject(url, Rating[].class);

//        assert ratingOfUser != null;
        var ratings = Arrays.asList(ratingOfUser);

        System.out.println("got rating of user**********"+ratings);

        var ratingList = ratings.stream().map(rating -> {
            var hotelUrl = "http://HOTEL-SERVICE/hotels/" + rating.getHotelId();
            var hotel = restTemplate.getForEntity(hotelUrl, Hotel.class);
//            System.out.println("got from hotel URL" + hotel);
            rating.setHotel(hotel.getBody());
            return rating;
        }).toList();


//        System.out.println("------------" + ratingList);
        user.setRatings(ratingList);

        return user;
    }
}
