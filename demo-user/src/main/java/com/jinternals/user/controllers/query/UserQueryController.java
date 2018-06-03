package com.jinternals.user.controllers.query;

import com.fasterxml.jackson.annotation.JsonView;
import com.jinternals.user.domain.View;
import com.jinternals.user.controllers.query.dto.UserQuerytDto;
import com.jinternals.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.jinternals.user.domain.View.V1.VND_USER_API_V1;
import static com.jinternals.user.domain.View.V2.VND_USER_API_V2;
import static com.jinternals.user.controllers.query.dto.UserQuerytDto.toDto;

@RestController
@RequestMapping("/api")
public class UserQueryController {

    private UserService userService;

    @Autowired
    public UserQueryController(UserService userService) {
        this.userService = userService;
    }


    @JsonView(View.V1.class)
    @GetMapping(value = "/user/{id}", produces = VND_USER_API_V1)
    @ResponseBody
    public UserQuerytDto getUserV1(@PathVariable("id") String id) {
        return toDto(userService.findById(id));
    }


    @GetMapping(value = "/user/{id}", produces = VND_USER_API_V2)
    @JsonView(View.V2.class)
    @ResponseBody
    public UserQuerytDto getUserV2(@PathVariable("id") String id) {
        return toDto(userService.findById(id));
    }

}
