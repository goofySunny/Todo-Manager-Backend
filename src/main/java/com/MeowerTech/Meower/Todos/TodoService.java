package com.MeowerTech.Meower.Todos;

import java.util.List;

import javax.naming.NameNotFoundException;

public interface TodoService {

    List<TodoModel> findAllByUsername(String username) throws  NameNotFoundException;

    TodoModel save(TodoModel todo, String username) throws  NameNotFoundException;

    TodoModel findById(String id) throws NameNotFoundException;

    void deleteById(String id) throws NameNotFoundException;

}