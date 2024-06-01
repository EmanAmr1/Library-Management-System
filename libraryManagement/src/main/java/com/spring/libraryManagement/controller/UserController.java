package com.spring.libraryManagement.controller;

import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import com.spring.libraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

@PostMapping("/login")
public ResponseEntity<?> LoginUser(@RequestBody User userData){
         return this.userService.LoginUser(userData);
}


@PostMapping("/signup")
    public ResponseEntity<?> SignupUser(@RequestBody User userData){
    return this.userService.SignupUser(userData);
}

}
