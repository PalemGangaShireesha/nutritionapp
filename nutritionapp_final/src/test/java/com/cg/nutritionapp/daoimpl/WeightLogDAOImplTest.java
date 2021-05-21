package com.cg.nutritionapp.daoimpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.cg.nutritionapp.dao.WeightLogDAO;
import com.cg.nutritionapp.daoimpl.WeightLogDAOImpl;
import com.cg.nutritionapp.model.WeightLog;



public class WeightLogDAOImplTest {
	private WeightLogDAO weightLogDAO ;
	WeightLog weightLog;

	@Before
	public void setUp()
	{
		weightLogDAO=new WeightLogDAOImpl();
	}


	@Test
	public void test_Save_Given_NullWeightLog_ShouldReturnNull()
	{

		weightLog=null;
		WeightLog weightLogTest=weightLogDAO.save(weightLog);
		assertNull(weightLogTest);
	}

	@Test
	public void test_Save_GivenWeightLog_ShouldReturnWeightLogObject()
	{
		LocalDate date=LocalDate.now();
		 weightLog=new WeightLog();
		 weightLog.setWeight(75);
		 weightLog.setCreated_At(date);
		 weightLog.setUpdated_At(date);
		 weightLog.setUserId("123");
		WeightLog weightLogTest=weightLogDAO.save(weightLog);
		assertNotNull(weightLogTest);
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void test_delete_Given_Null_returns_Null()
	{LocalDate date=LocalDate.now();
	WeightLog weightLog=new WeightLog(100,date,date,null);
	WeightLog update=weightLogDAO.delete(weightLog);
	
	}
	
	

	


}
