package com.alandsilva.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alandsilva.demo.dao.ProductDao;
import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.model.Product;
import com.alandsilva.demo.service.ProductService;
import com.alandsilva.demo.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getProducts() {
        return productDao.findAll();
    }

    @PostMapping
    public void addProduct(
            @RequestBody Product product) {
        productService.createProduct(product);
        return;
    }
}
