package com.main.service;

import com.main.dto.CategoryDTO;
import com.main.entity.Category;
import com.main.mapper.CategoryMapper;
import com.main.repository.CatogoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CatogoryRepo catogoryRepo;

    // create
    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Category  category =CategoryMapper.toCategoryEntity(categoryDTO);
        category= catogoryRepo.save(category);
        return CategoryMapper.toCategoryDTO(category);


    }
    // get all
    public List<CategoryDTO> getAllCategories(){

        return catogoryRepo.findAll().stream().map(CategoryMapper :: toCategoryDTO).toList();

    }
    // get by id
        public CategoryDTO getCategoryById(Long id){

            Category category=catogoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    // delete

    public String deleteCategory(Long id){

        catogoryRepo.deleteById(id);
        return "Category Deleted Successfully";
    }
}
