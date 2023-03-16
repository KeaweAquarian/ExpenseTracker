package com.KeaweAquarian.ExpenseTracker.service;

import com.KeaweAquarian.ExpenseTracker.Repository.RoleRepository;
import com.KeaweAquarian.ExpenseTracker.Repository.UserRepository;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getUserName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {} new role {}", roleName, userName);
          User user = userRepository.findByUserName(userName);
          Role role = roleRepository.findByName(userName);
          user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getUser() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
