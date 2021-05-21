package com.cg.helper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.nutritionapp.constants.DietPlanConstants;
import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.service.DietPlanService;
import com.cg.nutritionapp.serviceimpl.DietPlanServiceImpl;


public class DietPlanHelper {

	Scanner scanner=new Scanner(System.in);
	DietPlan dietPlan;
	DietPlanService dietPlanService=new DietPlanServiceImpl();
	DietPlanServiceImpl dietPlanServiceImpl=new DietPlanServiceImpl();

	public static long Id;
	public static String userId;
	public static String slots;
	public static String foodType;
	public static double proteinRatio;
	public static double fatRatio;
	public static double carbsRatio;
	public static double total;

	/**
	 * case 1 method when user wants to insert a dietplan into database
	 */
	public  void case1() throws DietPlanException {
		System.out.println("Enter the id:");
		Id=scanner.nextInt();
		System.out.println("Enter the user id:");
		userId=scanner.nextLine();
		System.out.println("Enter the slots: (morning meal | evening meal) ");
		slots=scanner.nextLine();
		System.out.println("Enter food type:(veg | non-veg)");
		foodType=scanner.nextLine();

		if(slots.equalsIgnoreCase(DietPlanConstants.MORNING_MEAL)) {
			if(foodType.equalsIgnoreCase(DietPlanConstants.VEG) ) {
				proteinRatio = DietPlanConstants.VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.VEG_CARBS_RATIO;
				total = DietPlanConstants.VEG_TOTAL;
			}
			else {
				proteinRatio = DietPlanConstants.NON_VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.NON_VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.NON_VEG_CARBS_RATIO;
				total = DietPlanConstants.NON_VEG_TOTAL;
			}
		}
		else if(slots.equalsIgnoreCase(DietPlanConstants.EVENING_MEAL)) {
			if(foodType.equalsIgnoreCase(DietPlanConstants.VEG)) {
				proteinRatio = DietPlanConstants.VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.VEG_CARBS_RATIO;
				total = DietPlanConstants.VEG_TOTAL;
			}
			else
			{
				proteinRatio = DietPlanConstants.NON_VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.NON_VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.NON_VEG_CARBS_RATIO;
				total = DietPlanConstants.NON_VEG_TOTAL;
			}
		}
			dietPlan=new DietPlan(Id,userId,slots,foodType,proteinRatio,fatRatio,carbsRatio,total);
			System.out.println(dietPlan);
			dietPlanService.save(dietPlan);
	
	}

	/**
	 * case 2 method when user wants to see all dietPlan of table dietPlan
	 */
	public void case2() {
		List<DietPlan> list=new ArrayList<DietPlan>();
		list=dietPlanService.findAll();
		for(DietPlan dp:list) {
			System.out.println(dp);
		}

	}

	
	/**
	 * case 3 method when user wants to update a dietplan  
	 */
	public void case3() throws DietPlanException {
		System.out.println("Enter the id of dietPlan you want to update:");
		Long id=scanner.nextLong();

		System.out.println("Enter the new dietPlan slots (morning meal | evening meal)");
		scanner.nextLine();
		slots=scanner.nextLine();
		
		System.out.println(slots);
		System.out.println("Enter the new foodType (veg | non-veg)");
		foodType=scanner.nextLine();

		if(slots.equalsIgnoreCase(DietPlanConstants.MORNING_MEAL)) {
			if(foodType.equalsIgnoreCase(DietPlanConstants.VEG) ) {
				proteinRatio = DietPlanConstants.VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.VEG_CARBS_RATIO;
				total = DietPlanConstants.VEG_TOTAL;
			}
			else {
				proteinRatio = DietPlanConstants.NON_VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.NON_VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.NON_VEG_CARBS_RATIO;
				total = DietPlanConstants.NON_VEG_TOTAL;
			}
		}
		else if(slots.equalsIgnoreCase(DietPlanConstants.EVENING_MEAL)) {
			if(foodType.equalsIgnoreCase(DietPlanConstants.VEG)) {
				proteinRatio = DietPlanConstants.VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.VEG_CARBS_RATIO;
				total = DietPlanConstants.VEG_TOTAL;
			}
			else
			{
				proteinRatio = DietPlanConstants.NON_VEG_PROTEIN_RATIO;
				fatRatio = DietPlanConstants.NON_VEG_FAT_RATIO;
				carbsRatio = DietPlanConstants.NON_VEG_CARBS_RATIO;
				total = DietPlanConstants.NON_VEG_TOTAL;
			}
		}


		dietPlan= new DietPlan(id,userId, slots, foodType, proteinRatio, fatRatio, carbsRatio, total);

		dietPlanService.update(id,slots,foodType);

	}

		

		/**
		 *  this method case4()is here to get service of deleting a dietplan by its Id from db.
		 */
		public void case4() {
			System.out.println("Enter the id to delete the project");
			long id=scanner.nextLong();
			dietPlan=dietPlanServiceImpl.deleteDietPlanById(id);
			System.out.println(dietPlan);
			
		}


}
