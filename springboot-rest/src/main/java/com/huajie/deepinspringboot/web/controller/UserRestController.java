package com.huajie.deepinspringboot.web.controller;

import com.huajie.deepinspringboot.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link User}
 */
@RestController
public class UserRestController {

    @PostMapping("/echo/user")
    public User user(@RequestBody User user) {
        return user;
    }

}
