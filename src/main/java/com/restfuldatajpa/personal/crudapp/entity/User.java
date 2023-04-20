package com.restfuldatajpa.personal.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@Column(name = "Phone_Number")
	@JsonIgnore
	private long phoneNumber;

	@JsonIgnore
	private String password;

	@JsonIgnore
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
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

	public User(String name, long phoneNumber, String password, String email) {
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
