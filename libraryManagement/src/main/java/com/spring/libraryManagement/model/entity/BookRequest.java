package com.spring.libraryManagement.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_name" , referencedColumnName = "userName" )
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id" , referencedColumnName = "id" )
    private Book book;

    private LocalDateTime requestDate;

    
    private LocalDateTime cancelDate;


    private Boolean isReq;

    public BookRequest(User user, Book book, LocalDateTime requestDate) {
        this.user = user;
        this.book = book;
        this.requestDate = requestDate;
    }
}
