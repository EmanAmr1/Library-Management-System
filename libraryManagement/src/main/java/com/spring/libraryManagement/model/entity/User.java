package com.spring.libraryManagement.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_login")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private String userName;
    private String password;
}
