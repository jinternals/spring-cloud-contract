package com.jinternals.user.consumer.v2.contollers;

import com.jinternals.user.consumer.v2.client.User;
import com.jinternals.user.consumer.v2.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserClient userClient;


    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserV2(@PathVariable("id") String id) {
        return userClient.getUserById(id);
    }


}
