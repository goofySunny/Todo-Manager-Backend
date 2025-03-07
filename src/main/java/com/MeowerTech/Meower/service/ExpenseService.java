package com.MeowerTech.Meower.service;

import java.util.List;

import com.MeowerTech.Meower.model.ExpenseModel;

public interface ExpenseService {

    ExpenseModel getExpenseById(String id);

    List<ExpenseModel> getExpensesByUser(String username);

    ExpenseModel saveExpense(ExpenseModel obj);

    void deleteExpenseById(String id);

    ExpenseModel updateExpense(ExpenseModel obj, String id);

}
