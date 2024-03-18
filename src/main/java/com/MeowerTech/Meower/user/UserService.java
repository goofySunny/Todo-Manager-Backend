package com.MeowerTech.Meower.user;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String username) throws ClassNotFoundException;

}