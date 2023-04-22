package com.restfuldatajpa.personal.crudapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfuldatajpa.personal.crudapp.entity.User;
import com.restfuldatajpa.personal.crudapp.entity.UserJsonResponse;
import com.restfuldatajpa.personal.crudapp.exception.UserNotFoundException;
import com.restfuldatajpa.personal.crudapp.repository.UserRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UserService {

	public static final Logger log = Logger.getLogger(UserService.class);

	@Autowired
	private Validator validator;

	@Autowired
	private UserRepository repo;

	// 1. Add new user

	public String create(User user) {

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		log.info("...................Inside create of UserService.class");
		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<User> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}

		log.info("....................Inside create of UserService.class");

		repo.save(user);
		return "Account for " + user.getName() + " Added!";
	}

	// 2. Count users

	public long count() {
		return repo.count();
	}

	// 3. Delete user

	public void delete(int id) {

		User user = repo.getReferenceById(id);

		if (user == null) {
			log.info("................inside if block { DELETE /users/id }");

			throw new UserNotFoundException("User with Id: " + id + " not found!!");
		} else {
			log.info("................inside else block { DELETE /users/id }");

			repo.deleteById(id);
		}
	}

	// 4. return one user

	public UserJsonResponse showOne(int id) {
		User user = repo.getReferenceById(id);

		if (user == null) {
			log.info("................inside if block { GET /users/id }");

			throw new UserNotFoundException("User with Id: " + id + " not found!!");
		} else {
			log.info("................inside else block { GET /users/id }");

			return new UserJsonResponse(user.getId(), user.getName());
		}
	}

	// 5. return all users

	public List<UserJsonResponse> showAll() {
		List<User> userList = repo.findAll();
		List<UserJsonResponse> userJsonResponsesList = new ArrayList<>();
		for (User user : userList) {
			UserJsonResponse userJsonResponse = new UserJsonResponse(user.getId(), user.getName());
			userJsonResponsesList.add(userJsonResponse);
		}
		return userJsonResponsesList;
	}

	// 6. Find by name and return User

	public UserJsonResponse showOneByName(String name) {
		User user = repo.findByName(name);

		if (user == null) {
			log.info("................inside if block { GET /users/name }");

			throw new UserNotFoundException("User with name: " + name + " not found!!");
		} else {
			log.info("................inside else block { GET /users/name }");

			return new UserJsonResponse(user.getId(), user.getName());
		}

	}

	// 7. Find by Phone Number and return User

	public UserJsonResponse showOneByPhoneNumber(String phoneNumber) {
		User user = repo.findByPhoneNumber(phoneNumber);

		if (user == null) {
			log.info("................inside if block { GET /users/phone-number }");

			throw new UserNotFoundException("User with phone number: " + phoneNumber + " not found!!");
		} else {
			log.info("................inside else block { GET /users/phone-number }");

			return new UserJsonResponse(user.getId(), user.getName());
		}
	}

	// 8. Find by email and return User

	public UserJsonResponse showOneByEmail(String email) {
		User user = repo.findByName(email);

		if (user == null) {
			log.info("................inside if block { GET /users/email }");

			throw new UserNotFoundException("User with Email: " + email + " not found!!");
		} else {
			log.info("................inside else block { GET /users/email }");

			return new UserJsonResponse(user.getId(), user.getName());
		}

	}
}
