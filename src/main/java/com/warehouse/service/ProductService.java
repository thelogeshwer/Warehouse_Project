package com.warehouse.service;

import com.warehouse.model.Product;
import com.warehouse.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void addProduct(Product product) {

        productRepo.save(product);
    }


    public void updateProduct(Product product) {

        productRepo.save(product);
    }

}
