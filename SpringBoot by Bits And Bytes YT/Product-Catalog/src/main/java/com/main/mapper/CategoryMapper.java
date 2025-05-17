package com.main.mapper;

import com.main.dto.CategoryDTO;
import com.main.entity.Category;

public class CategoryMapper {


    public static CategoryDTO toCategoryDTO(Category category){
        if(category==null){
            return null;
        }

        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper :: toProductDTO).toList());
    return  categoryDTO;
    }



    public static Category toCategoryEntity(CategoryDTO categoryDTO){

        Category category=new Category();
        category.setName(categoryDTO.getName());
        return category;
    }


}
