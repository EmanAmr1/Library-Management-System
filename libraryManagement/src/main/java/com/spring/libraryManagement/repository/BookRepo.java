package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
