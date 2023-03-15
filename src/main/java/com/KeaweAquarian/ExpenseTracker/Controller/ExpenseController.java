package com.KeaweAquarian.ExpenseTracker.Controller;

import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;
    @CrossOrigin
    @GetMapping("/expenses")
    List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }
    @CrossOrigin
    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?>  deleteExpense(@PathVariable Long id){
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin
    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws URISyntaxException{
        Expense result= expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
    }
}
