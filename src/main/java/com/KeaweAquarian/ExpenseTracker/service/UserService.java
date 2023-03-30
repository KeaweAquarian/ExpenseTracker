package com.KeaweAquarian.ExpenseTracker.service;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Category saveCategory(Category category);
    Expense saveExpense(Expense expense);
    List<Role>getRoles();
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUser();

    void uploadUserProfileImage(Long id, MultipartFile file);

    Category getCategory(Long id);

    byte[] downloadUserProfileImage(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, String firstName, String lastName, String username, String password, String userProfileImageLink);
}
