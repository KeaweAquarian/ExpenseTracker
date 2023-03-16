package com.KeaweAquarian.ExpenseTracker.Controller;

import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import com.KeaweAquarian.ExpenseTracker.Repository.UserRepository;
import com.KeaweAquarian.ExpenseTracker.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUsers(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("role")
    public ResponseEntity<Role> saveUsers(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("role/add")
    public ResponseEntity<?> addRole(@RequestBody RoleAddForm form){
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleAddForm{
        private String userName;
        private String roleName;
    }




}
