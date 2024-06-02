package com.spring.libraryManagement.controller;

import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.UserRepo;
import com.spring.libraryManagement.service.BookRequsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book-requests")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookRequestController {

    @Autowired
    private BookRequsetService bookRequsetService;
    @Autowired
    private UserRepo userRepo;


    @PostMapping("/request")
    public BookRequest requestBook(@RequestParam String username, @RequestParam Long bookId) {
        return bookRequsetService.requestBook(username, bookId);
    }


    @GetMapping("/user/{username}")
    public List<BookRequest> getRequestsByUser(@PathVariable String username) {
        User user = userRepo.findUserByUserName(username);
        return bookRequsetService.getRequestsByUser(user);
    }

}