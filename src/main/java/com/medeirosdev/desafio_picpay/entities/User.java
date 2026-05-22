package com.medeirosdev.desafio_picpay.entities;

import com.medeirosdev.desafio_picpay.enums.UserType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String document;

    private BigDecimal balance;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public User(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public void withdraw(BigDecimal amount){

        this.balance = this.balance.subtract(amount);

    }

    public void deposit(BigDecimal amount){

        this.balance = this.balance.add(amount);

    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
