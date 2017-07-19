package com.jinternals.user.controllers;

import com.jinternals.commons.logger.InjectLogger;
import com.jinternals.user.domain.User;
import com.jinternals.user.dto.UserDTO;
import com.jinternals.user.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.jinternals.user.dto.UserDTO.fromDTO;
import static com.jinternals.user.dto.UserDTO.toDTO;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	@InjectLogger
	private Logger logger;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	@ResponseBody
	User createUser(@Valid @RequestBody UserDTO userDTO) {
		logger.info("Creating user with email id: {}",userDTO.getEmail());
		return userService.createUser(fromDTO(userDTO));
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	@ResponseBody
	List<UserDTO> getAllUser() {
		logger.info("Getting all users");
		return toDTO(userService.getAllUser());
	}

}
