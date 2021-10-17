package com.backenwebmail.impl;

import com.backenwebmail.entity.User;
import com.backenwebmail.repository.UserRepository;
import com.backenwebmail.security.EncriptadorAES;
import com.backenwebmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private EncriptadorAES encriptadorAES;


    @Override
    public List<User> getAllUsers() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> result = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean valitUser(User user) {
        boolean valor = false;
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            if (userRepository.findByPassword(user.getPassword()).isPresent()) {
                valor = true;
            }
        }
        return valor;
    }

    @Override
    public boolean createUser(User user) {
        boolean response = false;
        try {
            if (!user.isEmpty()) {
                if (user.getRol().equals("Admin")) {
                    String newPass = encriptadorAES.encript(user.getPassword(), user.getEmail());
                    user.setPassword(newPass);
                }
                User userNew = userRepository.save(user);
                response = userNew.isGood();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return response;
    }


    @Override
    public List<User> findUserRol(String rol) {
        List<User> users = null;
        try {
            users = userRepository.findByRol(rol);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User changePassword(String password, String userName) {
        User response = null;
        try {
            Optional<User> user = userRepository.findByPasswordAndUsername(password, userName);
            if (user.isPresent()) {
                User us = user.get();
                us.setPassword(password);
                response = userRepository.save(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }


    @Override
    public User updateUser(User user) {
        User response = null;
        try {
            Optional<User> userUnit = userRepository.findByUsername(user.getUsername());
            if (userUnit.isPresent()) {
                User userwork = userUnit.get();
                if (!userwork.isEmpty()) {
                    if (userwork.getRol().equals("Admin") && user.getRol().equals("Admin")) {
                        String newPass = encriptadorAES.encript(user.getPassword(), user.getEmail());
                        user.setPassword(newPass);
                    }
                    response = userRepository.save(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }


    @Override
    public void deleteUser(String name) {
        try {
            Optional<User> userUnit = userRepository.findByUsername(name);
            if (userUnit.isPresent()) {
                User user = userUnit.get();
                userRepository.deleteById(user.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
