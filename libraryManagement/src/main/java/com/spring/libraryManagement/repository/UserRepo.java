package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);
}
