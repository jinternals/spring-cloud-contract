package com.jinternals.user.controllers;

import com.jinternals.user.domain.User;
import com.jinternals.user.dto.UserDTO;
import com.jinternals.user.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.jinternals.user.dto.UserDTO.fromDTO;

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
    User createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(fromDTO(userDTO));
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    Page<User> getAllUser(Pageable pageable) {
        return userService.getAllUser(pageable);
    }

}
