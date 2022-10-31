package com.alandsilva.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alandsilva.demo.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
