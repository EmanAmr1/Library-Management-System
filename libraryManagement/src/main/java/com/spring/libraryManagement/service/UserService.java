package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.Role;
import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {





    @Autowired
    UserRepo userRepo;


    public List<User> allUsers(){
        return this.userRepo.findAll();
    }

    public ResponseEntity<?> LoginUser(User userData){
        User user =userRepo.findUserByUserName(userData.getUserName());
        if(user.getPassword().equals(userData.getPassword()) && user.getRole().equals(userData.getRole()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }



    public ResponseEntity<?> SignupUser( User userData){
        Role defaultRole = new Role();
        defaultRole.setId(2L);
        defaultRole.setRoleName("student");
        userData.setRole(defaultRole);
        User userSignupDta =this.userRepo.save(userData);




        return ResponseEntity.ok(userSignupDta);
    }



}
