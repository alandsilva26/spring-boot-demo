package com.alandsilva.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alandsilva.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Iterable<Product> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product", Product.class)
                .list();
        session.getTransaction().commit();
        session.close();
        return products;
    }

    @Override
    public Long save(Product entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Brand WHERE product_id = :productId");
        query.setParameter("productId", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void update(Product entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterable<Product> findByBrandId(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = session
                .createQuery("from Product WHERE brand_id = :brandId", Product.class)
                .setParameter("brandId", id)
                .list();
        transaction.commit();
        session.clear();

        return products;
    }

}