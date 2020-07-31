package com.example.codeengine.expenseTracker.controller;


import com.example.codeengine.expenseTracker.model.Expense;
import com.example.codeengine.expenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    @PostMapping("/expenses")
    ResponseEntity<Expense> postExpense(@Valid @RequestBody Expense expense) throws URISyntaxException {
        Expense result = expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
    }

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
