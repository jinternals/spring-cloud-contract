package com.jinternals.user.controllers;

import com.jinternals.user.domain.User;
import com.jinternals.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseBody
    User createUser(@Valid @RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        return userService.createUser(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    User createUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    Page<User> getAllUser(Pageable pageable) {
        return userService.getAllUser(pageable);
    }

}
