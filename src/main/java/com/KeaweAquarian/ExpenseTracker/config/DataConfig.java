package com.KeaweAquarian.ExpenseTracker.config;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import com.KeaweAquarian.ExpenseTracker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@Configuration
public class DataConfig {
    @Bean
    CommandLineRunner run(UserService userService){
        return args ->
        {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"John", "Rays", "john", "1234", "workKeawe.jpg-8d0faa01-2477-4446-9944-7dc66b063f48", new ArrayList<Role>()));
            userService.saveUser(new User(null,"Will", "Topper", "will", "1234", null, new ArrayList<Role>()));
            userService.saveUser(new User(null,"Jan", "Bears", "jan", "1234", null, new ArrayList<Role>()));
            userService.saveUser(new User(null,"Cindy", "Lou", "cindy", "1234", null, new ArrayList<Role>()));
            userService.saveUser(new User(null,"Ken", "Davids", "ken", "1234", null, new ArrayList<Role>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("john", "ROLE_ADMIN");
            userService.addRoleToUser("will", "ROLE_ADMIN");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("cindy", "ROLE_USER");
            userService.addRoleToUser("ken", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("jan", "ROLE_USER");
            userService.addRoleToUser("jan", "ROLE_MANAGER");

            userService.saveCategory(new Category(null,"Travel"));
            userService.saveCategory(new Category(null,"Utilities"));
            userService.saveCategory(new Category(null,"Marketing"));
            userService.saveCategory(new Category(null,"Meals"));
            userService.saveCategory(new Category(null,"Equipment"));
            userService.saveCategory(new Category(null,"Bank Fees"));
            userService.saveCategory(new Category(null,"Employee Benefit Program"));
            userService.saveCategory(new Category(null,"Insurance"));
            userService.saveCategory(new Category(null,"Maintenance and Repairs"));
            userService.saveCategory(new Category(null,"Legal and Professional Expenses"));

            userService.saveExpense(new Expense(null, 400, new Date(), "Business meeting in Quebec City", "Quebec City", userService.getCategory(1L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 600, new Date(), "Power Bill", "Montreal", userService.getCategory(2L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 354.02F, new Date(), "Banking account setuo", "Montreal", userService.getCategory(6L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 98.42F, new Date(), "Office party", "Montreal", userService.getCategory(4L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 700, new Date(), "Employee Labtop", "Montreal", userService.getCategory(5L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 55.69F, new Date(), "Painting offices", "Montreal", userService.getCategory(9L) , userService.getUser("john")));
            userService.saveExpense(new Expense(null, 1200, new Date(), "Acounting Firm Invoice for 2022", "Quebec City", userService.getCategory(10L) , userService.getUser("john")));
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

