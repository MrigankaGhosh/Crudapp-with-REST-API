package com.restfuldatajpa.personal.crudapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {

	/**
	 * Custom exception created
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String message) {
		super(message);
	}
}
