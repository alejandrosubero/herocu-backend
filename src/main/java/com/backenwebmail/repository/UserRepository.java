package com.backenwebmail.repository;

import java.util.List;
import java.util.Optional;

import com.backenwebmail.execiones.UsernameOrIdNotFound;
import org.springframework.data.repository.CrudRepository;

import com.backenwebmail.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String userName);
    public Optional<User> findByPassword(String password);
    public Optional<User> findByPasswordAndUsername(String password, String userName);
    public List<User> findByRol(String rol);
}
