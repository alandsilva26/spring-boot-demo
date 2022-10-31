package com.alandsilva.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.alandsilva.demo.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByTitle(String title);
}
