package com.backenwebmail.service;

import com.backenwebmail.entity.User;


public interface UserService {

	public Iterable <User> getAllUsers();
	
	public boolean valitUser(User user);
	
	
	public boolean createUser(User user) throws Exception;	 
	
	//public User getUserById(Long id) throws Exception;

	//public User updateUser( User user) throws Exception;

	//public void deleteUser(Long id) throws  UsernameOrIdNotFound;
	
	//public User changePassword(String passwordForm) throws Exception;
	
}
