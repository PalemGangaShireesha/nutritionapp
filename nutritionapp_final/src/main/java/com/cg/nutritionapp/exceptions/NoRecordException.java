package com.cg.nutritionapp.exceptions;

public class NoRecordException extends Exception {
	public NoRecordException() {
		super();
	}
	public NoRecordException(String errMsg) {
		super(errMsg);
	}
}
