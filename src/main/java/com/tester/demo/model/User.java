package com.tester.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
//import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    private String surname;
    @Email
    @Column(name = "mail", unique = true)
    private String mail;
    private Integer balance;
    private LocalDate registrationDate;
    @NonNull
    @Column(name = "login", unique = true)
    private String login;
    private String password;
}
