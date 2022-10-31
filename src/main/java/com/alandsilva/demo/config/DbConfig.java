package com.alandsilva.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alandsilva.demo.model.Brand;
import com.alandsilva.demo.model.Product;
import com.alandsilva.demo.service.ProductService;

@Configuration
public class DbConfig {

    Logger logger = LoggerFactory.getLogger(DbConfig.class);
}
