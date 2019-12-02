package com.backenwebmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backenwebmail.modelo.User;
import com.backenwebmail.service.UserService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/checkusuario")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/sigin")
	public String siginAction(@RequestBody User user, BindingResult result) {
		
		if (userService.valitUser(user)) {
			return "25867025867";
		}else {
		return "0000000";
		}
		
	}
	
	
	
}
