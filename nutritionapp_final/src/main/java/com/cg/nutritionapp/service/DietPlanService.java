package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;

/**
 * this layer is working as bridge between presentation layer(MenuUtil) and domain layer(DietPlanDAO)
 * it declares all methods for all services according to our business need that a user can get for 
 * DietPlan module, their return type and argument details.
 */
public interface DietPlanService {
	
	/**
	 * This method addProduct() calls the method presents in dietPlanDAO to add a dietPlan in database 
	 * and return the same.
	 */
	public DietPlan save(DietPlan dietplan) throws DietPlanException;
	
	/**
	 * This method updateDietPlanSlotsAndFoodType() calls the method presents in DietPlanDAO to update a dietPlan 
	 *  by taking id.
	 */ 
	public DietPlan update(long id, String slots, String foodType) throws DietPlanException;
	
	/**
	 * This method getAllDietPlans() calls the method presents in DietPlanDAO to get a list of all dietplan 
	 * available in database.
	 */ 
	public List<DietPlan> findAll();
	
	/**
	 * This method deleteDietPlanById() calls the method presents in DietPlanDAO to delete a dietPlan 
	 * from database by its ID.
	 */ 
	public DietPlan deleteDietPlanById(long id);
	

}
