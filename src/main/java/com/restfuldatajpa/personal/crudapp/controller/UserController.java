package com.restfuldatajpa.personal.crudapp.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restfuldatajpa.personal.crudapp.entity.User;
import com.restfuldatajpa.personal.crudapp.entity.UserJsonResponse;
import com.restfuldatajpa.personal.crudapp.exception.NoDataFoundException;
import com.restfuldatajpa.personal.crudapp.services.UserService;

@RestController
@RequestMapping("/users")
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

	@GetMapping("")
	public List<UserJsonResponse> displayAllData() {
		List<UserJsonResponse> users = service.showAll();
		if (users.isEmpty()) {
			throw new NoDataFoundException("No data found in the database!!");
		} else {
			return users;
		}

	}

	// 2. Count the number of users present

	@GetMapping("/count")
	public long totalNumberOfData() {
		long count = service.count();
		return count;
	}

	// 3. Add a new User

	@PostMapping("")
	public Object addData(@RequestBody User user) {
		log.info("...................Inside  addData of UserController.class");
		return service.create(user);
	}

	// 4. Display a User by id

	@GetMapping("/id")
	public UserJsonResponse displayById(@RequestParam int id) {
		UserJsonResponse userJsonResponse = service.showOne(id);

		return userJsonResponse;

	}

	// 5. Delete a User by id

	@DeleteMapping("/id")
	public String deleteById(@RequestParam int id) {
		service.delete(id);
		
		return "Account for: " + id + " Deleted!";
	}

	// 6. Display a User by Name

	@GetMapping("/name")
	public UserJsonResponse displayByName(@RequestParam String name) {
		UserJsonResponse userJsonResponse = service.showOneByName(name);

		return userJsonResponse;

	}

	// 7. Display a User by Phone Number

	@GetMapping("/phone-number")
	public UserJsonResponse displayByPhoneNumber(@RequestParam String phoneNumber) {
		UserJsonResponse userJsonResponse = service.showOneByPhoneNumber(phoneNumber);

		return userJsonResponse;

	}

	// 8. Display a User by Email

	@GetMapping("/email")
	public UserJsonResponse displayByEmail(@RequestParam String email) {
		UserJsonResponse userJsonResponse = service.showOneByEmail(email);

		return userJsonResponse;

	}

}