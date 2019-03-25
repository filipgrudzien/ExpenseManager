package com.expensetracker.entities;

import com.expensetracker.constraints.UniqueUserEmail;
import com.expensetracker.constraints.UniqueUserLogin;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column(name = "login", unique = true)
    @NotNull(message = "Login field cannot remain null!")
    @NotEmpty(message = "Login field cannot remain blank!")
    @UniqueUserLogin(message = "Such login already exist!")
    private String login;

    @Column(name = "password")
    @Size(min = 8, max = 20)
    @NotNull(message = "Password field cannot remain null!")
    @NotEmpty(message = "Password field cannot remain blank!")
    private String password;

    @Email
    @Column(name = "email", unique = true)
    @UniqueUserEmail(message = "Such email already exist!")
    @NotNull(message = "Email field cannot remain null!")
    @NotEmpty(message = "Email field cannot remain blank!")
    private String email;

    @URL
    @Column(name = "photourl")
    private String photourl;

    @Column(name = "mobile")
    @Size(min = 9, max = 9)
    private String mobile;

    @Column(name = "gender")
    private String gender;

    @Column(name = "homeland")
    private String homeland;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "userid")
    List<Budget> listOfBudgets = new ArrayList<>();

}
