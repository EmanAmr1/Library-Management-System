package com.spring.libraryManagement.model.entity;

import java.time.LocalDateTime;

public class UserRequestDto {
    private String userName;
    private LocalDateTime requestDate;

    private  LocalDateTime cancelDate;


    public LocalDateTime getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDateTime cancelDate) {
        this.cancelDate = cancelDate;
    }

    public UserRequestDto(String userName, LocalDateTime requestDate, LocalDateTime cancelDate) {
        this.userName = userName;
        this.requestDate = requestDate;
        this.cancelDate = cancelDate;
    }

    public UserRequestDto(String userName, LocalDateTime requestDate) {
        this.userName = userName;
        this.requestDate = requestDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }


}
