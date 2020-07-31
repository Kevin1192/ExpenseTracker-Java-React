package com.example.codeengine.expenseTracker.repository;

import com.example.codeengine.expenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
