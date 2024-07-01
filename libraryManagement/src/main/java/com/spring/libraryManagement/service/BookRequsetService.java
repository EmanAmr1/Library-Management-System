package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import com.spring.libraryManagement.model.entity.UserRequestDto;
import com.spring.libraryManagement.repository.BookRepo;
import com.spring.libraryManagement.repository.BookRequestRepo;
import com.spring.libraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        // Check if the user has already requested the book
        boolean hasRequested = bookRequestRepo.existsByUserAndBookAndIsReqIsTrue(user, book);
        if (hasRequested) {
            throw new IllegalStateException("You have already requested this book.");
        }

        //get the user requested book
        BookRequest bookRequest = new BookRequest(user, book, LocalDateTime.now());
        bookRequest.setIsReq(true);
        return bookRequestRepo.save(bookRequest);
    }



     public void  deleteBookReq(String username, Long bookId){
        User user = userRepo.findUserByUserName(username);
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        BookRequest bookRequest = bookRequestRepo.findByUserAndBookAndCancelDateIsNull(user, book); //m3ml4 cancel before
       
         bookRequest.setIsReq(false);
        bookRequest.setCancelDate(LocalDateTime.now());
        bookRequestRepo.save(bookRequest);
    }



    public List<BookRequest> getRequestsByUser(User user) {
        return bookRequestRepo.findByUserAndCancelDateIsNull(user);   //all requests that not canceled before
    }


    public List<UserRequestDto> getUsernamesForBook(Long bookId) {
        List<UserRequestDto> userRequests = new ArrayList<>();

        List<BookRequest> bookRequests = bookRequestRepo.findByBookId(bookId);

        for (int i = 0; i < bookRequests.size(); i++) {
            BookRequest bookRequest = bookRequests.get(i);
            String username = bookRequest.getUser().getUserName();
            LocalDateTime requestDate = bookRequest.getRequestDate();
            LocalDateTime cancelDate = bookRequest.getCancelDate();
            userRequests.add(new UserRequestDto(username, requestDate, cancelDate));
        }

        return userRequests;
    }



}
