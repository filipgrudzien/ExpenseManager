package com.expensetracker.entities;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

    @URL
    @Column(name = "photourl")
    private String photourl;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "gender")
    private String gender;

    @Column(name = "homeland")
    private String homeland;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "userid")
    List<Budget> listOfBudgets = new ArrayList<>();

}
