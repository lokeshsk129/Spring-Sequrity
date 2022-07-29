package com.iSteer.mail.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iSteer.mail.model.UserPojo;
import com.iSteer.mail.service.UserService;
import com.iSteer.mail.user.User;

@RestController 
public class UserController {

	@Autowired
	UserService userService;

	//sending the request for registration 
	@PostMapping(value = "/register1")
	public User Register(@RequestBody User user) {
	return this.userService.createUser(user);
	}

	//sending the request for registration with OTP
	@PostMapping(value = "/register")
	public ResponseEntity<?> userVerfication(@RequestBody UserPojo request) {
	Map<String, Object> map = new HashMap<>();
	String user = userService.userIdVerification(request);
	map.put("message", user);
	return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.OK);
	}
    
	//verifying the OTP and returning token
	@PostMapping(value = "/otpVerify")
	public ResponseEntity<?> otpVerify(@RequestBody UserPojo request) throws NoSuchAlgorithmException {
	Map<String, Object> map = new HashMap<>();
	String response = userService.otpVerify(request);
	if (response.equals("expires")) {
	   map.put("message", "otp expired");
	return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.OK);
		}
	if (response.equals("not verified")) {
	   map.put("message", "not verified");
	return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.OK);
	} else {
	   map.put("message", "success");
	   map.put("Token", response);
	   return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.OK);
		}

	}

}
