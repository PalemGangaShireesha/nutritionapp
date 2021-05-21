package com.cg.nutritionapp.exceptions;
/**
 * this will create PaymentException object without showing error
 * @author admin
 *
 */
public class PaymentException extends Exception {
	
public PaymentException() {
	super();
}
public PaymentException(String errMsg) {
	super(errMsg);
}
}
