package com.main.service;


import com.main.dto.ProductDTO;
import com.main.entity.Category;
import com.main.entity.Product;
import com.main.mapper.ProductMapper;
import com.main.repository.CatogoryRepo;
import com.main.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepo productRepo;
    private CatogoryRepo catogoryRepo;

    //create
    public ProductDTO createProduct(ProductDTO productDTO){

       Category category = catogoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not Found"));

       //dto -> entity
        Product product= ProductMapper.toProductEntity(productDTO,category);
        product=productRepo.save(product);

        //entity ->dto
       return ProductMapper.toProductDTO(product);

    }

    //get all
    public List<ProductDTO> getAllProduct(){
        return productRepo.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    //get by id
    public ProductDTO getById(Long id){

        Product  product= productRepo.findById(id).orElseThrow(()->new RuntimeException("Product was not found"));

        return ProductMapper.toProductDTO(product);

    }

    //update
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){

        Product  product= productRepo.findById(id).orElseThrow(()->new RuntimeException("Product was not found"));
       Category category=catogoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));

       product.setName(productDTO.getName());
       product.setDescription(productDTO.getDescription());
       product.setPrice(productDTO.getPrice());
       product.setCategory(category);

       productRepo.save(product);

               return ProductMapper.toProductDTO(product);

    }

    //delete
    public String daleteProduct(Long id){
        productRepo.deleteById(id);

        return "Product"+id+"Deleted";
    }

}
