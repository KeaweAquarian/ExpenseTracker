package com.KeaweAquarian.ExpenseTracker.Repository;

import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
