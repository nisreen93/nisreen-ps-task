package com.demo.exception.handler;

public class DataIntegrityViolationException extends RuntimeException {
	public DataIntegrityViolationException(String message) {
		super(message);
	}
}
