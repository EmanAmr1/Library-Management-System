package com.spring.libraryManagement.controller;

import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

@PostMapping("/login")
public ResponseEntity<?> LoginUser(@RequestBody User userData){
User user =userRepo.findUserByUserName(userData.getUserName());
if(user.getPassword().equals(userData.getPassword()))
    return ResponseEntity.ok(user);
return (ResponseEntity<?>) ResponseEntity.internalServerError();
}


}
