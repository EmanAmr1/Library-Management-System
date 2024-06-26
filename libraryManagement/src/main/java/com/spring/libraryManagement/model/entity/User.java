package com.spring.libraryManagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.libraryManagement.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_table")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<BookRequest> bookRequests;

    @Column(nullable = true)
    private Boolean enabled;

    @Column(name = "verification_code" ,updatable = false  )
    private String verificationCode;


    private String email;

}
