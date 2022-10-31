package com.alandsilva.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alandsilva.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
