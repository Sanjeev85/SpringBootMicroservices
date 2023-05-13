package com.example.hotelservice.repositories;

import com.example.hotelservice.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String > {
}
