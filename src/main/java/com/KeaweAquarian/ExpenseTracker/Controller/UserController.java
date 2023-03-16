package com.KeaweAquarian.ExpenseTracker.Controller;

import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.Model.User;
import com.KeaweAquarian.ExpenseTracker.Repository.ExpenseRepository;
import com.KeaweAquarian.ExpenseTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping()
    List<User> getUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    ResponseEntity<User> createExpense(@RequestBody User user) throws URISyntaxException {
        User result= userRepository.save(user);
        return ResponseEntity.created(new URI("/api/user" + result.getId())).body(result);
    }

}
