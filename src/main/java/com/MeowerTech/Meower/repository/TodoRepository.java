package com.MeowerTech.Meower.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeowerTech.Meower.model.TodoModel;
import com.MeowerTech.Meower.model.User;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, String> {

    List<TodoModel> findAllByUser(User user);
}
