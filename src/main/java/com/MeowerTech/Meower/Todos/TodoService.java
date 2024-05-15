package com.MeowerTech.Meower.Todos;

import java.util.List;

import javax.naming.NameNotFoundException;

public interface TodoService {

    List<TodoModel> findAllByUsername(String username) throws ClassNotFoundException;

    TodoModel save(TodoModel todo, String username) throws ClassNotFoundException;

    TodoModel findById(String id) throws NameNotFoundException;

    TodoModel deleteById(String id);

}