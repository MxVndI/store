package com.tester.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
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
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @Email
    private String mail;
    private Integer balance;
    private LocalDate registrationDate;
    @NonNull
    private String login;
    private String password;
}
