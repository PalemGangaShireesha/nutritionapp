package com.cg.nutritionapp.serviceimpl;

import java.util.List;

import com.cg.nutritionapp.dao.DietPlanDAO;
import com.cg.nutritionapp.daoimpl.DietPlanDAOImpl;
import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.service.DietPlanService;


/*
 * It is the only implementation of DietPlanService interface.
 */
public class DietPlanServiceImpl implements DietPlanService {

	private DietPlanDAO dietPlanDAO; 
	public DietPlanServiceImpl() {
		dietPlanDAO=new DietPlanDAOImpl();
	}
	
	/**
	 * 	it is the implementation of method saveDietPlan() of  DietPlanService interface
	 */
	@Override
	public DietPlan save(DietPlan dietPlan) throws DietPlanException {
		return dietPlanDAO.save(dietPlan);			
	}

	
	/**
	 * 	it is the implementation of method updateDietPlan() of  DietPlanService interface
	 */
	@Override
	public DietPlan update(long id, String slots, String foodType) throws DietPlanException {
		return dietPlanDAO.update(id,slots,foodType);
							
	}

	
	/**
	 * 	it is the implementation of method getAllDietPlan() of  DietPlanService interface
	 */
	@Override
	public List<DietPlan> findAll() {
		return dietPlanDAO.findAll();
	}
	
	
	
	/**
	 * 	it is the implementation of method deleteDietPlanByID() of  DietPlanService interface
	 */
	@Override
	public DietPlan deleteDietPlanById(long id) {
		return dietPlanDAO.deleteDietPlanById(id);
	}
	
	
	

}
