package com.KeaweAquarian.ExpenseTracker;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.User;
import com.KeaweAquarian.ExpenseTracker.Repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}



}
