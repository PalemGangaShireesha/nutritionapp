package com.cg.helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.nutritionapp.dao.WeightLogDAO;
import com.cg.nutritionapp.daoimpl.WeightLogDAOImpl;
import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.util.*;
/**
 * This class works with the inplementation part of the funtionality selected.
 * Processing of data and choices entered by user is done here.
 * @author 
 *
 */

public class WeightLogCases {
	/*
	 * stores weight for user.
	 */
	Integer weight;
	/*
	 * To get date from system and autometically updates in data save and update by user.
	 */
	LocalDate date=LocalDate.now();
	/**
	 * stores userid of user
	 */
	String userId;
	Scanner scanner=new Scanner(System.in);
	 WeightLog weightLog;
	WeightLogDAO weightLogDAO;
	
	MenuUtil menu=new MenuUtil();
	WeightLogAvailability weightLogAvailability=new WeightLogAvailability();
	
	
	/**
	 * case1 gives implementation for save.
	 * process the save request by the user.
	 * @throws Exception 
	 */
	public void case1() throws Exception 
	{
		
		weightLogDAO=new WeightLogDAOImpl();
		System.out.println("Enter Weight LOG Details to be saved");
		System.out.println("Enter userId : ");
		userId=scanner.next();
		weightLogAvailability.checkUserIdSave(userId);
		System.out.println("Enter weight : ");
		weight=scanner.nextInt();
		
		weightLog=new WeightLog(weight,date,date,userId);
		weightLogDAO.save(weightLog);
	}
	/**
	 * case2 gives implementation for display.
	 * process display save request by the user.
	 */
	public void case2() 
    {
		weightLogDAO=new WeightLogDAOImpl();
    	List<WeightLog> list=new ArrayList<WeightLog>();
			list=weightLogDAO.findAll();
		
		for(WeightLog p:list) {
			System.out.println(p);
		}
    }
	/**
	 * case3 gives implementation for update.
	 * process the update request by the user.
	 * @throws Exception 
	 */
    public void case3() throws Exception 
    {
    	weightLogDAO=new WeightLogDAOImpl();	
	System.out.println("Enter your unique userid to update weight : ");
	userId=scanner.next();
	weightLogAvailability.checkUserIdExists(userId);
	System.out.println("Enter weight : ");
	weight=scanner.nextInt();
	weightLog=new WeightLog(weight,date,date,userId);
	weightLogDAO.update(weightLog);
	
    	}
    /**
	 * case4 gives implementation for delete.
	 * process the delete request by the user.
     * @throws Exception 
	 */
    public void case4() throws Exception
    {
    	weightLogDAO=new WeightLogDAOImpl();
	System.out.println("Enter Product Details to be deleted");
	System.out.println("Enter id userId : ");
	userId=scanner.next();
	weightLogAvailability.checkUserIdExists(userId);
	System.out.println("\n\nAre you sure to delete your WeightLog \n [y]Delete [Any key] Don't Delete");
	String delData=scanner.next();
	if(delData.equalsIgnoreCase("y"))
	{
		weightLog=new WeightLog(1,date,date,userId);
		weightLogDAO.delete(weightLog);
    }
}
}