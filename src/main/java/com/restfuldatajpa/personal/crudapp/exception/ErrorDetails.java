package com.restfuldatajpa.personal.crudapp.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime localDateTime;
	private String message;
	private String description;

	@Override
	public String toString() {
		return String.format("ErrorDetails [localDateTime=%s, message=%s, description=%s]", localDateTime, message,
				description);
	}

	public ErrorDetails(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
