package com.KeaweAquarian.ExpenseTracker.Repository;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByName() {
        //given
        Category category = new Category(null,"Travel");

        underTest.save(category);

        //when
        Category result = underTest.findByName(category.getName());

        //then
        assertEquals(category, result);
    }
}