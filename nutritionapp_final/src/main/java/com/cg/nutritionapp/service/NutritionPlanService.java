package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.model.NutritionPlan;
/**
 * This interface is used for providing services
 * @author 
 *
 */

public interface NutritionPlanService {
	public NutritionPlan save(NutritionPlan nutritionPlan);
	public List<NutritionPlan> findAll();
	public NutritionPlan update(NutritionPlan nutritionPlan);
	public NutritionPlan delete(NutritionPlan nutritionPlan);
}
