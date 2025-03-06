package com.MeowerTech.Meower.user;

import java.util.List;

import javax.naming.NameNotFoundException;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String username) throws NameNotFoundException;

}