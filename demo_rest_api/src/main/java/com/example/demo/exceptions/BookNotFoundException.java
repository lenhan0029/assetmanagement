package com.example.demo.exceptions;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String message) {
		super(message);
	}

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
