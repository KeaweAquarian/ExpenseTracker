package com.KeaweAquarian.ExpenseTracker;

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

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args ->
		{
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"John Rays", "john", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null,"Will Topper", "will", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null,"Jan Bears", "jan", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null,"Cindy Lou", "cindy", "1234", new ArrayList<Role>()));
			userService.saveUser(new User(null,"Ken Davids", "ken", "1234", new ArrayList<Role>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_ADMIN");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("cindy", "ROLE_USER");
			userService.addRoleToUser("ken", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jan", "ROLE_USER");
			userService.addRoleToUser("jan", "ROLE_MANAGER");
		};
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}

