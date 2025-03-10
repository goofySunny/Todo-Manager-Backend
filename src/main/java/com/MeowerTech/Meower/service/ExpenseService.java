package com.MeowerTech.Meower.service;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.MeowerTech.Meower.model.ExpenseModel;

public interface ExpenseService {

    ExpenseModel getExpenseById(String id) throws NameNotFoundException;

    List<ExpenseModel> getExpensesByUser(String username) throws NameNotFoundException;

    ExpenseModel saveExpense(ExpenseModel obj, String username) throws NameNotFoundException;

    void deleteExpenseById(String id) throws NameNotFoundException;

    ExpenseModel updateExpense(ExpenseModel obj, String id) throws NameNotFoundException;

}
