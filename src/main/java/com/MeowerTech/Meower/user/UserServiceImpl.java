package com.MeowerTech.Meower.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;


    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(String username) throws ClassNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ClassNotFoundException("User does not exist"); 
        }
        
    }

}
