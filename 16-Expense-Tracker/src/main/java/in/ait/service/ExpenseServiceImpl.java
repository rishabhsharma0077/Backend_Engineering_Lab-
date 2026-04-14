package in.ait.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ait.entity.Expense;
import in.ait.repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseService {
      @Autowired
	 private  ExpenseRepository repo;

	   

	    public Expense addExpense(Expense expense) {
	        return repo.save(expense);
	    }

	    public List<Expense> getAllExpenses() {
	        return repo.findAll();
	    }

	    public Expense updateExpense(Long id, Expense expense) {
	        Expense existing = repo.findById(id).orElseThrow();
	        existing.setTitle(expense.getTitle());
	        existing.setCategory(expense.getCategory());
	        existing.setAmount(expense.getAmount());
	        return repo.save(existing);
	    }

	    public void deleteExpense(Long id) {
	        repo.deleteById(id);
	    }
	}