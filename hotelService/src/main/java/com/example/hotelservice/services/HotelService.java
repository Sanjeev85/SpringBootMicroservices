package com.example.hotelservice.services;

import com.example.hotelservice.entities.Hotel;
import com.example.hotelservice.exceptions.ResourceNotFoundException;
import com.example.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel create(Hotel hotel) {
        return hotelRepository.insert(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Execption occureed mongodb"));
    }


}
