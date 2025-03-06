package com.MeowerTech.Meower.service;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.MeowerTech.Meower.model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String username) throws NameNotFoundException;

}