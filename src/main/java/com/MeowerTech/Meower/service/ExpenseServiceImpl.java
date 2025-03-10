package com.MeowerTech.Meower.service;

import java.time.LocalDate;
import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import com.MeowerTech.Meower.model.ExpenseModel;
import com.MeowerTech.Meower.model.User;
import com.MeowerTech.Meower.repository.ExpenseRepository;
import com.MeowerTech.Meower.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {


    private final UserRepository userRepository;
    private final ExpenseRepository repository;

    @Override
    public ExpenseModel getExpenseById(String id) throws NameNotFoundException {
        return repository.findById(id).orElseThrow(() -> new NameNotFoundException());
    }

    @Override
    public List<ExpenseModel> getExpensesByUser(String username) throws NameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NameNotFoundException("User Not Found"));
        return repository.findAllByUser(user);
    }

    @Override
    public ExpenseModel saveExpense(ExpenseModel obj, String username) throws NameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NameNotFoundException("User Not Found"));
        // TODO : obj.setUser(user);
        obj.setDateOfAddition(LocalDate.now());
        return repository.save(obj);
    }

    @Override
    public void deleteExpenseById(String id) throws NameNotFoundException {
        repository.findById(id).orElseThrow(() -> new NameNotFoundException("Not Found"));
        repository.deleteById(id);
    }

    @Override
    public ExpenseModel updateExpense(ExpenseModel obj, String id) throws NameNotFoundException {
        ExpenseModel old = repository.findById(id).orElseThrow(() -> new NameNotFoundException("Not found"));
        old.setAmount(obj.getAmount() == 0 ? old.getAmount() : obj.getAmount());
        old.setDate(obj.getDate() == null ? old.getDate() : obj.getDate());
        return repository.save(old);
    }

}
