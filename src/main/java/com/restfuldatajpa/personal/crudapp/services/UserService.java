package com.restfuldatajpa.personal.crudapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfuldatajpa.personal.crudapp.entity.User;
import com.restfuldatajpa.personal.crudapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	// 1. Add new user

	public User create(User user) {
		return repo.save(user);
	}

	// 2. Count users

	public long count() {
		return repo.count();
	}

	// 3. Delete user

	public void delete(int id) {
		repo.deleteById(id);
	}

	// 4. return one user

	public Optional<User> showOne(int id) {
		return repo.findById(id);
	}

	// 5. return all users

	public List<User> showAll() {
		return repo.findAll();
	}

}
