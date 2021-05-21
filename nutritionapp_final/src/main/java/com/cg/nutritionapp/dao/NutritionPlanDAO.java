package com.cg.nutritionapp.dao;

import java.util.List;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;

/**
 * NutritionPlan interface for creating different methods of CRUD
 * @author 
 *
 */

public interface NutritionPlanDAO {
	/**
	 * save method is used to insert records in the table in DB
	 */
	public NutritionPlan save(NutritionPlan nutritionPlan);
	/**
	 * findAll method is used to fetch records from the DB
	 * @return
	 */
	public List<NutritionPlan> findAll() throws NutritionPlanException;
	/**
	 * update method is used to update record in the table in DB
	 * @param nutritionPlan
	 */
	public NutritionPlan update(NutritionPlan nutritionPlan);
	/**
	 * delete method is used to delete a record from the table in DB
	 * @param nutritionPlan
	 */
	public NutritionPlan delete(NutritionPlan nutritionPlan);

}
