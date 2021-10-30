package com.backenwebmail.controller;

import com.backenwebmail.entity.Nota;
import com.backenwebmail.execiones.NotalecturaOrIdFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.backenwebmail.entity.User;
import com.backenwebmail.service.UserService;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/newUser")
	public boolean createUser(@RequestBody User user, BindingResult result){
		return userService.createUser(user);
	}

	@PostMapping("/ChanguePassword")
	public boolean ChanguePassword(@RequestBody User user, BindingResult result){
		User userAdmin = userService.changePassword(user.getPassword(), user.getUsername());
		if (userAdmin!= null){
			return true;
		}
		return false;
	}

	@PostMapping("/updateUser")
	public boolean updateUser(@RequestBody User user, BindingResult result){
		User userAdmin = userService.updateUser(user);
		if (userAdmin!= null){
			return true;
		}
		return false;
	}

	@GetMapping("/delete/{name}")
	public boolean deleteUser(@PathVariable("name")String name) throws NotalecturaOrIdFound {
		userService.deleteUser(name);
		return true;
	}

	@GetMapping("/findByRol/{rol}")
	public List<User>  findUserByRol(@PathVariable("rol")String rol) throws NotalecturaOrIdFound {
		List<User> users = userService.findUserRol(rol);
		return users;
	}

	@GetMapping("getAll")
	public List<User> getAllUser()  {
		return  userService.getAllUsers();
	}

}
