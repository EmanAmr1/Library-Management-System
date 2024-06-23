package com.spring.libraryManagement.service;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public List<Book> getAllBooks(){
        return this.bookRepo.findAll();
    }

    public Book  addBook(Book book){return  this.bookRepo.save(book);
    }
}
