package com.MeowerTech.Meower.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeowerTech.Meower.model.ExpenseModel;
import com.MeowerTech.Meower.service.ExpenseService;

import lombok.RequiredArgsConstructor;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService service;

    @GetMapping("/{username}/expenses")
    public ResponseEntity<Object> getExpensesByUsername(@PathVariable String username) throws NameNotFoundException {
        return new ResponseEntity<>(service.getExpensesByUser(username), HttpStatus.OK);
    }

    @GetMapping("/{username}/expenses/{id}")
    public ResponseEntity<Object> getMethodName(@PathVariable String username, @PathVariable String id) throws NameNotFoundException {
        return new ResponseEntity<>(service.getExpenseById(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{username}/expenses/{id}")
    public ResponseEntity<Object> deleteExpenseById(@PathVariable String id) throws NameNotFoundException {
        service.deleteExpenseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
// This method needs verifying...
    @PostMapping("/{username}/expenses")
    public ResponseEntity<Object> createExpense(@PathVariable String username,@RequestBody ExpenseModel object) throws NameNotFoundException {
        ExpenseModel created = service.saveExpense(object, username);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/users/" + username + "/expenses/" + created.getId());
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

}
