package com.spring.libraryManagement.controller;

import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.service.UserService;
import com.spring.libraryManagement.site.Utility;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/allUsers")
    public List<User> allUsers(){
        return this.userService.allUsers();
    }


    @PostMapping("/login")
         public ResponseEntity<?> LoginUser(@RequestBody User userData){
                       return this.userService.LoginUser(userData);}


    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody User userData, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        if (userData.getEmail() == null || userData.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email address must not be null or empty");
        }
        this.userService.SignupUser(userData);

        String siteURL = Utility.getSiteURL(request);
        this.userService.sendVerificationEmail(userData, siteURL);

        return ResponseEntity.ok("User signed up successfully. Verification email sent.");
    }



    @GetMapping("/verify")
    public ModelAndView verifyAccount(@RequestParam("code") String code) {
        ModelAndView modelAndView = new ModelAndView();

        boolean verified = userService.verify(code);
        String pageTitle = verified ? "Verification Succeeded" : "Verification Failed";

        modelAndView.addObject("pageTitle", pageTitle);
        modelAndView.setViewName("verification/" + (verified ? "verify_success" : "verify_failed"));

        return modelAndView;
    }
}











