package com.tester.demo.storage;

import com.tester.demo.model.User;
import com.tester.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserStorage {
    private final UserRepository userRepository;

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User addUser(User user) {
        userRepository.save(user);
        user.setBalance(0);
        user.setRegistrationDate(LocalDate.now());
        return user;
    }

    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
