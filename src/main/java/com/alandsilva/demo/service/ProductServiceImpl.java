package com.alandsilva.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alandsilva.demo.dao.BrandDao;
import com.alandsilva.demo.dao.CategoryRepository;
import com.alandsilva.demo.dao.ProductDao;
import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.model.Brand;
import com.alandsilva.demo.model.Category;
import com.alandsilva.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void createProduct(Product product) {

        // category
        Category category = null;
        category = categoryRepository.findByTitle(product.getCategory().getTitle());
        if (category == null) {
            category = categoryRepository.save(product.getCategory());
        }

        // brand
        Brand brand = null;
        brand = brandDao.findByTitle(product.getBrand().getTitle());
        if (brand == null) {
            Long id = brandDao.save(product.getBrand());
            brand = new Brand();
            brand.setTitle(product.getBrand().getTitle());
            brand.setBrandId(id);
        }

        product.setCategory(category);
        product.setBrand(brand);

        productDao.save(product);
    }

    @Override
    public void createProduct(ProductCreationDto productCreationDto) {
        Brand brand = null;
        System.out.println(productCreationDto.brandTitle);
        brand = brandDao.findByTitle(productCreationDto.brandTitle);
        if (brand == null) {
            brand = new Brand(productCreationDto.brandTitle);
            Long id = brandDao.save(brand);
            brand.setBrandId(id);
        }
        Product product = new Product();
        product.setBrand(brand);
        product.setTitle(productCreationDto.title);
        product.setPrice(productCreationDto.price);
        product.setQuantity(productCreationDto.quantity);

        System.out.println(product);
        productDao.save(product);
    }

    @Override
    public Iterable<Product> findByBrandId(Long id) {
        return productDao.findByBrandId(id);
    }
}