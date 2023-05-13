package com.example.hotelservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
