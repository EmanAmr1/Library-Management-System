package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.Book;
import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRequestRepo extends JpaRepository<BookRequest,Long> {

    List<BookRequest> findByUser(User user);

    BookRequest findByUserAndBook(User user,Book book);

    boolean existsByUserAndBook(User user, Book book);

    List<BookRequest> findByBookId(Long bookId);



}
