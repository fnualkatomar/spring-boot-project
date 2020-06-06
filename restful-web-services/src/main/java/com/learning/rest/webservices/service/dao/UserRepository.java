package com.learning.rest.webservices.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.rest.webservices.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
