package com.spring.libraryManagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {


    private String userName;

    private LocalDateTime requestDate;

    private  LocalDateTime cancelDate;


}
