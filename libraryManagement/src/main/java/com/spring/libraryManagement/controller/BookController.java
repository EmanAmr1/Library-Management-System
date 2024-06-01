package com.spring.libraryManagement.controller;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> allBooks(){
        return  this.bookService.getAllBooks();
    }
}
