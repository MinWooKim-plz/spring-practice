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


    // U P D A T E

    // D E L E T E
}
