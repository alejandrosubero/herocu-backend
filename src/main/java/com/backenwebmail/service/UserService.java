package com.backenwebmail.service;

import com.backenwebmail.entity.User;

import java.util.List;


public interface UserService {

	public List<User> getAllUsers();
	public boolean valitUser(User user);
	public boolean createUser(User user);
	public List<User> findUserRol(String rol);
	public User changePassword(String password, String userName);
	public User updateUser( User user);
	public void deleteUser(String name);
}
