package in.ait.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ait.entity.Expense;


public interface ExpenseService {
	Expense addExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense updateExpense(Long id, Expense expense);
    void deleteExpense(Long id);

}
