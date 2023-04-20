package com.restfuldatajpa.personal.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfuldatajpa.personal.crudapp.entity.User;
import com.restfuldatajpa.personal.crudapp.services.UserService;

@RestController
public class UserController {

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

}
