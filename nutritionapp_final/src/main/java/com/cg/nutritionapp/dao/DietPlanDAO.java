package com.cg.nutritionapp.dao;

import java.util.List;

import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;

public interface DietPlanDAO {

	/**
	 * this save method is used for inserting records into table dietPlan
	 */
	public DietPlan save(DietPlan dietPlan) throws DietPlanException ;
	
	/**
	 * this update method is used for updating slots into table dietPlan
	 */
	public DietPlan update(long id,String slots, String foodType) throws DietPlanException;
	
	/**
	 * this update method is used for updating records into table products
	 */
	public List<DietPlan> findAll();

	/**
	 * this delete method is used for deleting records by id from table dietPlan
	 */
	
	public DietPlan deleteDietPlanById(long id);

	}


	
	
