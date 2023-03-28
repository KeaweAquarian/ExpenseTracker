package com.KeaweAquarian.ExpenseTracker;

import com.KeaweAquarian.ExpenseTracker.Controller.ExpenseController;
import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import com.KeaweAquarian.ExpenseTracker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		System.out.println(System.getenv("SECRET_KEY"));
		System.out.println(System.getenv("ACCESS_KEY"));
		SpringApplication.run(ExpenseTrackerApplication.class, args);

	}

}

