package com.restfuldatajpa.personal.crudapp.entity;

public class UserJsonResponse {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("UserJsonResponse [id=%s, name=%s]", id, name);
	}

	public UserJsonResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
