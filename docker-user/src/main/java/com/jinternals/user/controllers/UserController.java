package com.jinternals.user.controllers;

import com.cloud.example.user.domain.User;
import com.cloud.example.user.dto.UserDTO;
import com.cloud.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.cloud.example.user.dto.UserDTO.fromDTO;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	@ResponseBody
	User getMessages(@Valid @RequestBody UserDTO userDTO) {
		return userService.createUser( fromDTO(userDTO));
	}

}
