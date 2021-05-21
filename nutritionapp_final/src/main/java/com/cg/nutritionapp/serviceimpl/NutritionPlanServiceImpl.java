package com.cg.nutritionapp.serviceimpl;
import java.util.ArrayList;
import java.util.List;

import com.cg.nutritionapp.dao.NutritionPlanDAO;
import com.cg.nutritionapp.daoimpl.NutritionPlanDAOImpl;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.service.NutritionPlanService;
/**
 * This class provides the implementation of services
 * @author 
 *
 */

public class NutritionPlanServiceImpl implements NutritionPlanService {
	private NutritionPlanDAO nutritionPlanDAO;

	public NutritionPlanServiceImpl()
	{
		nutritionPlanDAO=new NutritionPlanDAOImpl();
	}

	@Override
	public NutritionPlan save(NutritionPlan nutritionPlan)
	{
		nutritionPlanDAO.save(nutritionPlan);
		return nutritionPlan;
	}

	@Override
	public List<NutritionPlan> findAll() 
	{
		List<NutritionPlan> nutritionPlan=new ArrayList<NutritionPlan>();
		try
		{
			nutritionPlan=nutritionPlanDAO.findAll();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return nutritionPlan;
	}

	@Override
	public NutritionPlan update(NutritionPlan nutritionPlan)
	{
		nutritionPlanDAO.update(nutritionPlan);
		return nutritionPlan;
	}

	@Override
	public NutritionPlan delete(NutritionPlan nutritionPlan)
	{
		nutritionPlanDAO.delete(nutritionPlan);
		return nutritionPlan;
	}
}
