package com.KeaweAquarian.ExpenseTracker.Repository;

import com.KeaweAquarian.ExpenseTracker.domain.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoleRepositoryTest {

    @Autowired
    RoleRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByName() {
        //given
        Role role = new Role(null, "ROLE_USER");

        underTest.save(role);

        //when
       Role result = underTest.findByName(role.getName());

        Role expected = role;

        //then
        assertEquals(expected, result);

    }
}