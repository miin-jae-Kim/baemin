package com.homes.baemin.controller;

import com.homes.baemin.common.exception.CustomException;
import com.homes.baemin.domain.User;
import com.homes.baemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.homes.baemin.common.exception.ErrorCode.USER_NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable("userId") long userId) {
        User user = userService.findUserById(userId);

        if (Objects.isNull(user)) throw new CustomException(USER_NOT_FOUND);
        return user;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
}
