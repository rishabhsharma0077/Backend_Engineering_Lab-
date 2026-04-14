package in.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import in.ait.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
