package com.restfuldatajpa.personal.crudapp.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfuldatajpa.personal.crudapp.entity.User;
import com.restfuldatajpa.personal.crudapp.exception.InvalidUserInputException;
import com.restfuldatajpa.personal.crudapp.exception.NoDataFoundException;
import com.restfuldatajpa.personal.crudapp.exception.UserNotFoundException;
import com.restfuldatajpa.personal.crudapp.services.UserService;

@RestController
public class UserController {

	public static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	// 1. Show all Users

	@GetMapping("/users")
	public List<User> displayAllData() {
		List<User> users = service.showAll();
		if (users.isEmpty()) {
			throw new NoDataFoundException("No data found in the database!!");
		} else {
			return users;
		}

	}

	// 2. Count the number of users present

	@GetMapping("/users/count")
	public long totalNumberOfData() {
		long count = service.count();
		return count;
	}

	// 3. Add a new User

	@PostMapping("/users")
	public void addData(@RequestBody User user) {
		if (user.getName().length() < 2) {
			throw new InvalidUserInputException("Name should have more than 2 characters!!");
		} else {
			service.create(user);
		}

	}

	// 4. Display a User by id

	@GetMapping("/users/{id}")
	public Optional<User> displayById(@PathVariable int id) {
		Optional<User> user = service.showOne(id);

		if (user.isEmpty()) {
			log.info(".............inside if block { GET /users/{id} }");

			throw new UserNotFoundException("User with id: " + id + " not found!!");
		} else {
			log.info("................inside else block { GET /users/{id} }");

			return user;
		}

	}

	// 5. Delete a User by id

	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		Optional<User> user = service.showOne(id);

		if (user.isEmpty()) {
			log.info(".............inside if block { DELETE /users/{id} }");

			throw new UserNotFoundException("User with id: " + id + " not found!!");
		} else {
			log.info("................inside else block { DELETE /users/{id} }");

			service.delete(id);
		}

	}

}