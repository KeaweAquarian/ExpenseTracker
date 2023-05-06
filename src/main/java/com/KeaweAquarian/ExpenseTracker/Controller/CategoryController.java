package com.KeaweAquarian.ExpenseTracker.Controller;

import com.KeaweAquarian.ExpenseTracker.Model.Category;
import com.KeaweAquarian.ExpenseTracker.Repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        super();
        this.categoryRepository = categoryRepository;
    }
    //Return list of categories
    @GetMapping("/categories")
    Collection<Category> categories(){
        return categoryRepository.findAll();
    }

    //Return individual category
    @GetMapping("/categories/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    //Add a category
    @PostMapping("/categories")
    ResponseEntity<Category> createCategory( @RequestBody Category category) throws URISyntaxException{
        Category result = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/categories" + result.getId())).body(result);
    }
    //Edit a category
    @PutMapping("/categories/{id}")
    ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category){
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }
    //Delete a category
    @DeleteMapping("/categories/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try{
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
