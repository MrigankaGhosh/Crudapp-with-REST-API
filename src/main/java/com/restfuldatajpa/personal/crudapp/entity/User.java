package com.restfuldatajpa.personal.crudapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Size(min = 2, max = 20, message = "Name should have 2 to 20 characters!!")
	private String name;

	@Column(name = "Phone_Number")
	@Size(min = 10, max = 10, message = "Phone Number should have exactly 10 characters!!")
	private String phoneNumber;

	@Size(min = 2, max = 20, message = "Password should have 2 to 20 characters!!")
	private String password;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public User(String name, String phoneNumber, String password, String email) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, phoneNumber=%s, password=%s, email=%s]", id, name, phoneNumber,
				password, email);
	}

}
