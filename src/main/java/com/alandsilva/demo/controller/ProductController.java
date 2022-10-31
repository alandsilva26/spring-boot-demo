package com.alandsilva.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alandsilva.demo.dao.ProductDao;
import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.exception.NoSuchElementException;
import com.alandsilva.demo.model.Product;
import com.alandsilva.demo.service.ProductService;
import com.alandsilva.demo.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getProducts() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    @ExceptionHandler(NoSuchElementException.class)
    public Product getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        System.out.println(product);
        return product;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addProduct(
            @RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public void editProduct(@PathVariable Long id, @RequestBody Product product) {

        // update product

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        // delete product
    }
}
