package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public ResponseEntity<?> LoginUser(User userData){
        User user =userRepo.findUserByUserName(userData.getUserName());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }



    public ResponseEntity<?> SignupUser( User userData){
        User userSignupDta =this.userRepo.save(userData);
        return ResponseEntity.ok(userSignupDta);
    }


}
