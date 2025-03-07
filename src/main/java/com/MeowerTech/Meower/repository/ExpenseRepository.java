package com.MeowerTech.Meower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeowerTech.Meower.model.ExpenseModel;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, String> {

}