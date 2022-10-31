package com.alandsilva.demo.service;

import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.model.Product;

public interface ProductService {

    Product findById(Long id);

    void createProduct(Product product);

    void createProduct(ProductCreationDto productCreationDto);

    Iterable<Product> findByBrandId(Long id);

    // void updateProduct(Product product);

    void deleteProduct(Long id);
}
