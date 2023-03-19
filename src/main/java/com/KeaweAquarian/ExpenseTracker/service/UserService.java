package com.KeaweAquarian.ExpenseTracker.service;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Category saveCategory(Category category);
    List<Role>getRoles();
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User>getUser();
}
