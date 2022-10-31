package com.alandsilva.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alandsilva.demo.dao.BrandDao;
import com.alandsilva.demo.model.Brand;
import com.alandsilva.demo.model.Product;
import com.alandsilva.demo.service.ProductService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Brand> getBrands() {
        return brandDao.findAll();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> postBrand(
            @RequestBody Brand brand) {
        brandDao.save(brand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Brand getBrand(@PathVariable Long id) {
        return brandDao.findById(id);
    }

    @GetMapping("/{id}/products")
    public Iterable<Product> getProducts(@PathVariable Long id) {
        return productService.findByBrandId(id);
    }
}
