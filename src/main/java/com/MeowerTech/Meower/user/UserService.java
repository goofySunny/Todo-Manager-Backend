package com.MeowerTech.Meower.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(String username) throws ClassNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ClassNotFoundException("User does not exist"); 
        }
        
    }

}
