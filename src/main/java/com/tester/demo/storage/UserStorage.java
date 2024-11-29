package com.tester.demo.storage;

import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.User;
import com.tester.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
//import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserStorage {
    private final UserRepository userRepository;
    private final CartStorage cartStorage;

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User addUser(User user) {
        user.setBalance(0);
        user.setRegistrationDate(LocalDate.now());
        //user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
        Cart cart = new Cart();
        cart.setUser(user);
        cartStorage.addCart(cart);
        return user;
    }

    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

//    private String hashPassword(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
}
