package com.jinternals.user.controllers.command;

import com.fasterxml.jackson.annotation.JsonView;
import com.jinternals.user.controllers.command.dto.UserCommandDto;
import com.jinternals.user.controllers.query.dto.UserQuerytDto;
import com.jinternals.user.domain.User;
import com.jinternals.user.domain.View;
import com.jinternals.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.jinternals.user.controllers.query.dto.UserQuerytDto.toDto;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class UserCommandController {

    private UserService userService;

    @Autowired
    public UserCommandController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(View.V1.class)
    @RequestMapping(path = "/user", method = POST)
    @ResponseBody
    UserQuerytDto createUser(@Valid @RequestBody UserCommandDto userCommandDto) {
        User user = UserCommandDto.fromDto(userCommandDto);
        user = userService.createUser(user);
        return toDto(user);
    }

}
