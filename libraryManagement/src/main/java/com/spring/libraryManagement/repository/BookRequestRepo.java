package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRequestRepo extends JpaRepository<BookRequest,Long> {


    boolean existsByUserAndBookAndIsReqIsTrue(User user, Book book); //can't req more than one

    List<BookRequest> findByBookId(Long bookId); //to get all usersName of this book

    BookRequest findByUserAndBookAndCancelDateIsNull(User user, Book book); //to make a request


    List<BookRequest> findByUserAndCancelDateIsNull(User user);  // To get not canceled requests only

}
