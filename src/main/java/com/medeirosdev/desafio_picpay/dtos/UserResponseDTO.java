package com.medeirosdev.desafio_picpay.dtos;

import com.medeirosdev.desafio_picpay.enums.UserType;

import java.math.BigDecimal;

public class UserResponseDTO {

    private String firstName;
    private String lastName;
    private String document;
    private BigDecimal balance;
    private String email;
    private UserType userType;

    public UserResponseDTO(String firstName, String lastName, String document, BigDecimal balance, String email, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.balance = balance;
        this.email = email;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
