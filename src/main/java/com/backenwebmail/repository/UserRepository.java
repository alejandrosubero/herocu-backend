package com.backenwebmail.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.backenwebmail.modelo.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByUsername(String userName);
	
	public Optional<User> findByPassword(String password);
	
}
