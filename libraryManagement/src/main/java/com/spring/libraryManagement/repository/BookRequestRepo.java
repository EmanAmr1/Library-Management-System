package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.BookRequest;
import com.spring.libraryManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRequestRepo extends JpaRepository<BookRequest,Long> {

    List<BookRequest> findByUser(User user);
}
