package com.upwork.app.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.app.model.User;
import com.upwork.app.service.UserService;

@RestController
@PropertySource("classpath:messages.properties")
public class LoginController {

	@Value("${success.message}")
	String successMessage;

	@Value("${error.message}")
	String errorMessage;

	@Autowired
	UserService userService;

	@RequestMapping("/loginReq")
	public ResponseEntity getLoggedInUser(@RequestBody User user) {
		ResponseEntity responseEntity;
		Map<String, String> resultMap = new HashMap<>();
		User existingUser = userService.checkLogin(user);
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			resultMap.put("message", successMessage);
			resultMap.put("userId", String.valueOf(existingUser.getUserId()));
			responseEntity = new ResponseEntity(resultMap, HttpStatus.OK);
		} else {
			resultMap.put("message", errorMessage);
			responseEntity = new ResponseEntity(resultMap, HttpStatus.UNAUTHORIZED);
		}
		return responseEntity;
	}

}
