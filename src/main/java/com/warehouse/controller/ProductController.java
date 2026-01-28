package com.warehouse.controller;

import com.warehouse.model.Product;
import com.warehouse.repository.ProductRepo;
import com.warehouse.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepo productRepo;




    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable("id") int prodId){
       Optional<Product> productOptional =  productRepo.findById(prodId);

       if(productOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID not valid");
       }

       productRepo.deleteById(prodId);
       return ResponseEntity.ok("Product deleted");

    }



    @GetMapping("/product/vendor")
    public ResponseEntity<?> findByVendor(@RequestParam("vendor") String vendor){

        List<Product> product = productRepo.findByVendor(vendor);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No vendor found");
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/get")
    public ResponseEntity<?> getAllProduct(){

        List<Product> product = productRepo.findAll();

        if(product.isEmpty()){
            return new ResponseEntity<>("No product exist", HttpStatus.BAD_REQUEST);
        }

        //return (ResponseEntity<?>) productOptional;
        return ResponseEntity.ok(product);

    }

    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product product){

        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product inserted successfully");
    }

    @PutMapping("product/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody Map<String,Integer> body,
                                                @PathVariable("id") int prodId){
        int price = body.get("price");
        int stock = body.get("stock");

        Optional<Product> productOptional = productRepo.findById(prodId);

        if(productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Product found");
        }

        Product product = productOptional.get();
        product.setPrice(price);
        product.setStock(stock);

        productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product update successfully");
    }


}
