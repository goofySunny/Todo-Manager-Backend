package com.MeowerTech.Meower.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.MeowerTech.Meower.model.User;
import com.MeowerTech.Meower.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;


    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(String username) throws NameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NameNotFoundException("User does not exist"); 
        }
        
    }

}
