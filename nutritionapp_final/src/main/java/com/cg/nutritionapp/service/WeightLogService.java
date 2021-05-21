package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.model.WeightLog;

public interface WeightLogService {
	public WeightLog addWeightLog(WeightLog weightLog);
	public WeightLog updateWeightLog(WeightLog weightLog);
	public void removeWeightLog(WeightLog weightLog);
	public List<WeightLog> showAllWeightLog();
}
