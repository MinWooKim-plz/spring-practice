package com.first.board.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // R E A D
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // C R E A T E
    public void addUser(User user) {
        userRepository.findUserById(user.getId()).ifPresent(u -> {
            throw new IllegalArgumentException("User with id " + user.getId() + " already exists.");
        });
        userRepository.findUserByEmail(user.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        });
        userRepository.save(user);
    }

    // U P D A T E

    // D E L E T E
}
