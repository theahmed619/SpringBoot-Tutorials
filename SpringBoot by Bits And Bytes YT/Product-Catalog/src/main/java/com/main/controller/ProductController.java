package com.main.controller;

import com.main.dto.ProductDTO;
import com.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //get products
    @GetMapping
    public List<ProductDTO> getAllCategory(){

        return productService.getAllProduct();
    }

    //get product by id
    //path param.  product ?  id="", name=""
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id){

        return  productService.getById(id);
    }

    //create products
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

   ProductDTO createdProduct=productService.createProduct(productDTO);
   return  new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }

    //update
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    public  ProductDTO updateProduct(@PathVariable Long id,  @RequestBody ProductDTO productDTO){
     return productService.updateProduct(id, productDTO);
    }

    //delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    public  String deleteId(@PathVariable Long id){

        return productService.daleteProduct(id);
    }
}
