package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        var user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        var user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updateUser) {
        var user = userService.getUser(userId);
        user = updateUser;
        return createUser(user);
    }


}
