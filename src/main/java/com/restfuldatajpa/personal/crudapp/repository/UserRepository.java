package com.restfuldatajpa.personal.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfuldatajpa.personal.crudapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
	User findByPhoneNumber(String phoneNumber);
	User findByEmail(String email);
}
