package com.cg.nutritionapp.serviceimpl;

import java.util.List;

import com.cg.nutritionapp.dao.DietPlanDAO;
import com.cg.nutritionapp.daoimpl.DietPlanDAOImpl;
import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.service.WeightLogService;

public class WeightLogServiceImpl implements WeightLogService{
	//private WeightLogDAO weightLogDAO; 
	//public WeightLogServiceImpl() {
		//weightLogDAO=new WeightLogDAOImpl();
	//}

	@Override
	public WeightLog addWeightLog(WeightLog weightLog){
		// TODO Auto-generated method stub
		//return weightPalnDAO.save(weightLog);	
		return null;
	}

	@Override
	public WeightLog updateWeightLog(WeightLog weightLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeWeightLog(WeightLog weightLog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WeightLog> showAllWeightLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
