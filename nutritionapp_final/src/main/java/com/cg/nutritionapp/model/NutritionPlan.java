package com.cg.nutritionapp.model;
/**
 * NutritionPlan class is created as a hub for data where attributes are added to the nutrition plan.
 */

import java.sql.Date;

public class NutritionPlan {
	/**
	 * ID of the Nutrition Plan
	 * ID is auto-generated
	 */
	Integer id;
	/**
	 * Name of the Nutrition Plan
	 */
	String name;
	/**
	 * Description of the Plan
	 */
	String planDescription;
	/**
	 * Date of creation of the Plan
	 */
	Date created_At;
	/**
	 * Date of updation of Plan
	 */
	Date updated_At;
	/**
	 * Price of the Plan
	 */
	Long price;

	public NutritionPlan()
	{
	}

	public NutritionPlan(String name, String planDescription, Date created_At, Date updated_At, Long price) 
	{
		super(); 
		this.name = name;
		this.planDescription = planDescription; 
		this.created_At = created_At;
		this.updated_At = updated_At; 
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NutritionPlan [name=" + name + ", planDescription=" + planDescription + ", created_At=" + created_At
				+ ", updated_At=" + updated_At + ", price=" + price + "]";
	}
	
}
