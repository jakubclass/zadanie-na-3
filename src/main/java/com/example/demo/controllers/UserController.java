package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    @PostMapping("users/add")
    public String CreateNewUser(@RequestBody User user  ) {


        return userService.addUser(user);
    }


    @GetMapping("users/byName")

    public List<User> getUserByName(@RequestParam("firstName") String firstName) {
        List<User> userByName = userService.findByName(firstName);


        for (User user : userByName) {
            System.out.println(user.getUniversity());
        }
        return userByName;
    }


    @GetMapping("/users")

    public List<User>  getAllUsers() {

        return userService.getAllUsers();
    }
}
