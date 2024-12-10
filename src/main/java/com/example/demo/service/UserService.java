package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> findByName(String username) {
        List<User> userByName = userRepository.findByUniversity(username);

        return userByName;

    }

    public String addUser(User user) {
        userRepository.save(user);

        return "User war created";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
