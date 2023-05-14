package com.example.hotelservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class staffController {
    @GetMapping
    public List<String> getStaffs() {
        return new ArrayList<>(Arrays.asList("emp1", "emp2", "emp3"));
    }

}

