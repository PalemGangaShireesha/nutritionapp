package com.cg.nutritionapp.daoimpl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.nutritionapp.dao.NutritionPlanDAO;
import com.cg.nutritionapp.daoimpl.NutritionPlanDAOImpl;
import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;

public class NutritionPlanDAOImplTest {
	private NutritionPlanDAO nutritionPlanDAO;

	@Before
	public void setUp()
	{
		nutritionPlanDAO = new NutritionPlanDAOImpl();
	}

	@Test (expected = NullPointerException.class)
	public void test_save_GivenNullNutritionPlanRef_ThrowNulllPointerException() {
		NutritionPlan nutritionPlan = null;
		NutritionPlan savedNutritionPlan=nutritionPlanDAO.save(nutritionPlan);
	}

	@Test
	public void test_save_GivenNutritionPlanWithSilverPlanName_ShouldReturnSilverPlan()
	{
		Date createDate=new Date(2020-12-01);
		Date updatedDate=new Date(2020-12-05);
		NutritionPlan nutritionPlan=new NutritionPlan("Silver Plan","Three Months Plan",createDate,updatedDate,1100L);		
		NutritionPlan savedNutritionPlan=nutritionPlanDAO.save(nutritionPlan);
		assertEquals("Silver Plan", savedNutritionPlan.getName());
	}

	@Test
	public void test_update_GivenNutritionPlanWithSilverPlanName_ShouldUpdatePlanDescription()
	{
		Date createDate=new Date(2020-12-01);
		Date updatedDate=new Date(2020-12-05);
		String plan="Three Months Plan with 1 Diet Plan";
		NutritionPlan nutritionPlan=new NutritionPlan("Silver Plan",plan,createDate,updatedDate,1100L);		
		NutritionPlan updateNutritionPlan=nutritionPlanDAO.update(nutritionPlan);
		assertEquals(plan, updateNutritionPlan.getPlanDescription());
	}

	@Test
	public void test_delete_GivenNutritionPlanWithSilverPlanName_ShouldReturnAndDeleteRecordOfSilverPlan()
	{
		Date createDate=new Date(2020-12-01);
		Date updatedDate=new Date(2020-12-05);
		String plan="Three Months Plan";
		NutritionPlan nutritionPlan=new NutritionPlan("Silver Plan",plan,createDate,updatedDate,1100L);		//**HERE**
		NutritionPlan deleteNutritionPlan=nutritionPlanDAO.delete(nutritionPlan);
		assertEquals(nutritionPlan, deleteNutritionPlan);
	}
}
