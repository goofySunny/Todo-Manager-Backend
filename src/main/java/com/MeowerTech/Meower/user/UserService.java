package com.MeowerTech.Meower.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

}
