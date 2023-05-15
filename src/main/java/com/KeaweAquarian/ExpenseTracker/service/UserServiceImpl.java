package com.KeaweAquarian.ExpenseTracker.service;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Model.Expense;
import com.KeaweAquarian.ExpenseTracker.Repository.CategoryRepository;
import com.KeaweAquarian.ExpenseTracker.Repository.ExpenseRepository;
import com.KeaweAquarian.ExpenseTracker.Repository.RoleRepository;
import com.KeaweAquarian.ExpenseTracker.Repository.UserRepository;
import com.KeaweAquarian.ExpenseTracker.bucket.BucketName;
import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import com.KeaweAquarian.ExpenseTracker.fileStore.FileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final CategoryRepository categoryRepository;

    private final ExpenseRepository expenseRepository;

    private final FileStore fileStore;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in database {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository
                .findByUserName(user.getUserName()));
        if (userOptional.isPresent()){
            throw new IllegalStateException("Username " + user.getUserName() + " is already associated with an account");
        }
        log.info("Saving new user {} to the database", user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    //Add new expence category
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    //Save an expense
    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    //Saving a user role
    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    //Adding a role to a user
    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {} new role {}", roleName, userName);
          User user = userRepository.findByUserName(userName);
          Role role = roleRepository.findByName(roleName);
          user.getRoles().add(role);
    }

    //finding user detials
    @Override
    public User getUser(String userName) {
        log.info("Fetching user {}", userName);
        return userRepository.findByUserName(userName);
    }
    @Override
    public List<Role> getRoles() {

        return roleRepository.findAll();
    }

    //Getting all users
    @Override
    public List<User> getUser() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    //Uploading a user profile image
    @Override
    public void uploadUserProfileImage(Long id, MultipartFile file) {
        if(!file.isEmpty()){
            if (!Arrays.asList(ContentType.IMAGE_JPEG, ContentType.IMAGE_GIF, ContentType.IMAGE_PNG).contains(file.getContentType())){
                User user = userRepository
                        .findAll()
                        .stream()
                        .filter(userProfile -> userProfile.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", id)));
                Map<String, String> metaData = new HashMap<>();
                metaData.put("Content-Type", file.getContentType());
                metaData.put("Content-Length", String.valueOf(file.getSize()));

                String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getId());
                String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
                try {
                    fileStore.save(path, fileName, Optional.of(metaData), file.getInputStream() );

                    user.setUserProfileImageLink(fileName);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }

            }else throw new IllegalStateException("Image must be of type jpeg, png or gif!");
        }else throw new IllegalStateException("File is empty!");
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.getById(id);
    }

    //Downloading a user profile image
    @Override
    public byte[] downloadUserProfileImage(Long id) {
        User user = userRepository
                .findAll()
                .stream()
                .filter(userProfile -> userProfile.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", id)));
        String path = String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                user.getId());
        return user.getUserProfileImageLink()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);
    }

    //Deleting a user
    @Override
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("User with id " + id + "does not exist");
        }
        userRepository.deleteById(id);
    }

    //Updating a user detials
    @Transactional
    @Override
    public void updateUser(Long id, String firstName, String lastName, String username, String password, String userProfileImageLink) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("User not found with id " + id));
        if(firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)){
            user.setLastName(lastName);
        }
        if(username != null && username.length() > 0 && !Objects.equals(user.getUserName(), username)){
            Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserName(username));
            if (userOptional.isPresent()){
                throw new IllegalStateException("Username " + username + " is already associated with an account");
            }
            user.setUserName(username);
        }
        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }

    }


}
