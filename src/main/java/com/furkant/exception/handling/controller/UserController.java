package com.furkant.exception.handling.controller;

import com.furkant.exception.handling.data.RestResponseGenerator;
import com.furkant.exception.handling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final RestResponseGenerator restResponseGenerator;

    @PostMapping
    public void createUser(@RequestParam String userName, @RequestParam String password) {
        userService.createUser(userName, password);
        restResponseGenerator.success();
    }
}