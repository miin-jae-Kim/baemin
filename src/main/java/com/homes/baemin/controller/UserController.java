package com.homes.baemin.controller;

import com.homes.baemin.domain.User;
import com.homes.baemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable("userId") long userId) {
        User user = userService.findUserById(userId);
        return user;
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
}
