package com.cg.nutritionapp.exceptions;

public class DuplicateIdException extends Exception {
	public DuplicateIdException() {
		super();
	}
	public DuplicateIdException(String errMsg) {
		super(errMsg);
	}
}
