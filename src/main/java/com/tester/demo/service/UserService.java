package com.tester.demo.service;

import com.tester.demo.model.User;
import com.tester.demo.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserStorage userStorage;

    public User getUserById(Integer id) {
        return userStorage.getUserById(id);
    }

    public User addUser(User user) {
        return userStorage.addUser(user);
    }

    public Collection<User> getUsers() {
        return userStorage.getUsers();
    }
}
