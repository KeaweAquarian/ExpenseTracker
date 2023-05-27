package com.KeaweAquarian.ExpenseTracker.Repository;

import com.KeaweAquarian.ExpenseTracker.domain.Role;
import com.KeaweAquarian.ExpenseTracker.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {


    @Autowired
    UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByUserName() {
        //given
        User user = new User(null,"Will",
                "Topper", "will", "1234",
                null, new ArrayList<Role>());
        underTest.save(user);
        //when
        User result = underTest.findByUserName(user.getUserName());

        //then
        assertEquals(user, result);
    }
}