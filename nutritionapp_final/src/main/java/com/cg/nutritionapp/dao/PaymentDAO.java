package com.cg.nutritionapp.dao;
import java.util.List;

import com.cg.nutritionapp.model.Payment;
/**
 * Payment Interface for creating different methods of CRUD
 * @author 
 *
 */
public interface PaymentDAO {
	/**
	 * This save method is used to insert record into payments table in DB NutritionApp
	 * @param payments
	 * @return
	 */
	public Boolean save(Payment payments);
	/**
	 * This findAll method is used to fetch all records from table payments in DB NutritionApp
	 * @param payments
	 * @return
	 */
	public List<Payment> findAll();
	/**
	 * This updtae method is used to update record into payments table in DB NutritionApp
	 * @param payments
	 * @return
	 */
	public Payment update(Payment payments);
	/**
	 * This delete method is used to delete record into payments table in DB NutritionApp
	 * @param payments
	 * @return
	 */
	public Payment delete(Payment payments);
	
}


