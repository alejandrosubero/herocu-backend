package com.backenwebmail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backenwebmail.modelo.User;
import com.backenwebmail.repository.UserRepository;
import com.backenwebmail.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	
	@Override
	public boolean valitUser(User user) {
		boolean valor=false;
		
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			if (userRepository.findByPassword(user.getPassword()).isPresent()) {
				valor = true;
			}
		}
		return valor;
	}


	@Override
	public boolean createUser(User user) throws Exception {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
