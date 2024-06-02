package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.repository.BookRepo;
import com.spring.libraryManagement.repository.BookRequestRepo;
import com.spring.libraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookRequsetService {

    @Autowired
    private BookRequestRepo bookRequestRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    public BookRequest requestBook(String username, Long bookId) {
        User user = userRepo.findUserByUserName(username);
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        //get the user requested book
        BookRequest bookRequest = new BookRequest(user, book, LocalDateTime.now());
        return bookRequestRepo.save(bookRequest);
    }


    public List<BookRequest> getRequestsByUser(User user) {
        return bookRequestRepo.findByUser(user);
    }
}