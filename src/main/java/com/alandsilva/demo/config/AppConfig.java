package com.alandsilva.demo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfig {

    // @Bean
    // @ConfigurationProperties(prefix = "datasource.mine")
    // public DataSource dataSource() {
    // BasicDataSource dataSource = new BasicDataSource();
    // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:3306/demoApp");
    // dataSource.setUsername("root");
    // dataSource.setPassword("root");
    // return dataSource;
    // }

    // @Bean
    // public LocalSessionFactoryBean sessionFactory() {
    // LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    // sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
    // sessionFactory.setPackagesToScan(new String[] { "com.alandsilva.demo.model"
    // });
    // return sessionFactory;
    // }

    // @Bean
    // public HibernateTransactionManager transactionManager() {
    // HibernateTransactionManager txManager = new HibernateTransactionManager();
    // txManager.setSessionFactory(sessionFactory());
    // return txManager;
    // }
}
