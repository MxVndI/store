package com.tester.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;

    @Email
    private String mail;

    private Integer balance;
    private LocalDate registrationDate;
    private String login;
    private String password;

    public User(String login, String password, String mail, String name, String surname) {
        this.login = login;
        this.password = password;
        //this.password = hashPassword(password);
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

//    private String hashPassword(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
}
