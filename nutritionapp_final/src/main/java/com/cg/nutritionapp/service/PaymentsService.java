package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.model.Payment;
/**
 * This is a service class to provide CRUD operation
 * @author 
 *
 */
public interface PaymentsService {
	public void addPayments(Payment payments);
	public List<Payment> listPayments();
	public Payment findPaymentsById(Long id);
	public void update(Payment payments);

}
