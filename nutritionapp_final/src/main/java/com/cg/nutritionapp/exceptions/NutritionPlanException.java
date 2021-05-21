package com.cg.nutritionapp.exceptions;

public class NutritionPlanException extends Exception{
	public static final long serialVersionUID=1L;
	
	/**
	 * Create NutritionPlanException object without error message 
	 */
	public NutritionPlanException()
	{
		super();
	}
	
	/**
	 * Create NutritionPlanException object with error message
	 * @param errMsg
	 */
	
	public NutritionPlanException(String errMsg)
	{
		super(errMsg);
	}

}
