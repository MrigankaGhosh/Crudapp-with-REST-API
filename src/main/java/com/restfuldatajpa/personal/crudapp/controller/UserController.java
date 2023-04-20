package com.restfuldatajpa.personal.crudapp.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfuldatajpa.personal.crudapp.entity.User;
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

	@GetMapping("/users")
	public List<User> displayAllData() {
		return service.showAll();
	}

	@PostMapping("/users")
	public void addData(@RequestBody User user) {
		service.create(user);
	}

	@GetMapping("/users/{id}")
	public Optional<User> displayById(@PathVariable int id) {
		Optional<User> user = service.showOne(id);

		if (user.isEmpty()) {
			log.info(user + " inside if block");

			throw new UserNotFoundException("User with id: " + id + " not found!!");
		} else {
			log.info(user + " inside else block");

			return user;
		}
	}

}
