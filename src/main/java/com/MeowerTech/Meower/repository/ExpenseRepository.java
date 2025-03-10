package com.MeowerTech.Meower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeowerTech.Meower.model.ExpenseModel;
import com.MeowerTech.Meower.model.User;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, String> {

    List<ExpenseModel> findAllByUser(User user);
}