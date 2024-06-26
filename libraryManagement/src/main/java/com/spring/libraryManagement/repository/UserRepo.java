package com.spring.libraryManagement.repository;

import com.spring.libraryManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);

    @Query("UPDATE User u SET u.enabled =true where u.id=?1")
    @Modifying
    public void enable(Long id);

    @Query("SELECT u FROM User  u where u.verificationCode=?1")
    public User findUserByVerificationCode(String code);
}
