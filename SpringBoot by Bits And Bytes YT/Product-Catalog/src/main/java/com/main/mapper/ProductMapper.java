package com.main.mapper;

import com.main.dto.ProductDTO;
import com.main.entity.Category;
import com.main.entity.Product;

public class ProductMapper {

    //toProductDto
    public static ProductDTO toProductDTO (Product product){
        return  new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()

        );

    }

    //DTO to entity

    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return  product;
    }
}
