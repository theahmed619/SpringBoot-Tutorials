package com.main.controller;


import com.main.dto.CategoryDTO;
import com.main.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    //get all
    @GetMapping
    public List<CategoryDTO> getAllCategories(){

       return  categoryService.getAllCategories();
    }

    // create
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){

        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }



    //by id
    @GetMapping("/{id}")
    public  CategoryDTO getCategoryById(@PathVariable Long id){

        return categoryService.getCategoryById(id);
    }

    //delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteCategory(@PathVariable Long id){

        return categoryService.deleteCategory(id);

    }
}
