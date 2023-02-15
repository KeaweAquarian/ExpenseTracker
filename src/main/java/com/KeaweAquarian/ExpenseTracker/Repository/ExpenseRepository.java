package com.KeaweAquarian.ExpenseTracker.Repository;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
