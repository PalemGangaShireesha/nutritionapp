package com.cg.nutritionapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.cg.helper.*;
import com.cg.nutritionapp.exceptions.*;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.serviceimpl.*;
import com.cg.nutritionapp.util.*;
/**
 * Inputs are taken through scanner in this class.
 * @author 
 *
 */

public class MenuUtil {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static UserServiceImpl ps = new UserServiceImpl();

	public void start() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("------------Nutrition App------------");
		System.out.println("1. Users");
		System.out.println("2. Nutrition Plans");
		System.out.println("3. Diet Plans");
		System.out.println("4. Weight Log");
		System.out.println("5. Payment");
		System.out.println("Enter your Choice = ");
		int i=sc.nextInt();

		switch(i)
		{
		case 1:
			String option = "";

			do
			{
				System.out.println("A. View Users");
				System.out.println("B. Add Users");
				System.out.println("C. Update Users");
				System.out.println("D. Delete User");
				System.out.println("E. Search User");
				System.out.println("F. View User plan");
				System.out.println("G. Exit");
				System.out.println("===========================================");
				System.out.println("Enter an option");
				System.out.println("===========================================");
				option = br.readLine();
				System.out.println("\n");

				switch(option.toUpperCase())
				{
				case "A":
					ps.viewUser();
					break;

				case "B":
					ps.addUser();
					break;

				case "C":
					ps.updateUser();
					break;

				case "D":
					ps.deleteUser();
					break;

				case "E":
					ps.searchUser();
					break;
		
				case "F":
					ps.viewUserDietPlan();
					break;

				case "G":
					System.out.println("******************************THANK YOU********************");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Option! Please enter again");
					break;
				}
			}while(!option.equals("F"));
			break;
		case 2:
			String decision="n";
			System.out.println("------------Nutrition Plans------------");
			System.out.println("1. Make A New Nutrition Plan");
			System.out.println("2. Display All Nutrition Plans");
			System.out.println("3. Update Plan Description Of A Nutrition Plan");
			System.out.println("4. Delete A Nutrition Plan");
			System.out.println("---------------------------------------");
			do {
				System.out.println("Please enter your choice : ");
				int choice=sc.nextInt();
				NutritionPlanServiceImpl nutritionPlanServiceImpl=new NutritionPlanServiceImpl();

				switch(choice)
				{
				case 1:
				{
					
			
					System.out.println("Enter Plan Name :");
					String name=sc.next();
					sc.nextLine();
					System.out.println("Enter the Plan Description :");
					String planDesc1=sc.next();
					String planDesc=planDesc1.replace('_',' ');
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis);
					Date createDate=date;
					Date updateDate=createDate;
					System.out.println("Enter the Price of Plan :");
					Long price=sc.nextLong();
					NutritionPlan nutritionPlan=new NutritionPlan(name,planDesc,createDate,updateDate,price);
					nutritionPlanServiceImpl.save(nutritionPlan);
					System.out.println("Plan Saved Successfully!");
				}
				break;
				case 2:
				{
					List<NutritionPlan> list=new ArrayList<NutritionPlan>();
					list=nutritionPlanServiceImpl.findAll();
					for(NutritionPlan np:list)
					{
						System.out.println(np);
					}
				}
				break;
				case 3:
				{
					System.out.println("Enter Plan Name whose Description you want to Update :");
					String name=sc.next();
					System.out.println("Enter the New Plan Descripton :");
					String planDesc1=sc.next();
					String planDesc=planDesc1.replace('_',' ');
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis);
					Date updateDate=date;
					NutritionPlan nutritionPlan=new NutritionPlan();
					nutritionPlan.setName(name);
					nutritionPlan.setPlanDescription(planDesc);
					nutritionPlan.setUpdated_At(updateDate);
					nutritionPlanServiceImpl.update(nutritionPlan);
					System.out.println("Plan Description of "+name+" is Updated to "+planDesc+" on "+updateDate);
				}
				break;
				case 4:
				{
					System.out.println("Enter Plan name whose record you want to delete :");
					String name=sc.next();
					NutritionPlan nutritionPlan=new NutritionPlan();
					nutritionPlan.setName(name);
					nutritionPlanServiceImpl.delete(nutritionPlan);
					System.out.println("Record of "+name+" is deleted!");
				}
				break;
				default:
					System.out.println("Please Enter a Valid Choice!!");
					break;
				}
				System.out.println("Do you want to continue? (y/n)");
				decision=sc.next();
			}while(decision.equalsIgnoreCase("y"));
			break;
		case 3:
			DietPlanHelper helper=new DietPlanHelper();
			System.out.println("enter your choice\n1 for adding a dietplan.\n2 for view all dietplan\n3 for updating a dietplan \n4 for deleting a dietplan ");
			int n=sc.nextInt();
			switch(n) {

			case 1:
				helper.case1();
				break;		

			case 2:
				helper.case2();
				break;		

			case 3:
				helper.case3();
				break;			
			case 4:
				helper.case4();
				break;


			default :
				System.out.println("Invalid choice");
				start();


			}
			System.out.println("\nDo you want to continue? enter \n1 for yes\n2 for no");
			int c=sc.nextInt();
			if(c==1)
				start();
			else
				System.out.println("Thanks");
			break;
		case 4:
			System.out.println("\nEnter Choice :\n 1.SAVE 2.DISPLAY 3.UPDATE 4.delete 5.EXIT");
			int choice= sc.nextInt();
			WeightLogCases helper1=new WeightLogCases();
			/**
			 * switch will give user to take any of the given values.
			 * And which let user do the many different things. 
			 */
			switch(choice)
			{ 
			case 1:
				helper1.case1();
				break;

			case 2:
				helper1.case2();
				break;

			case 3:
				helper1.case3();
				break;

			case 4:
				helper1.case4();
				break;
			case 5:
				System.out.println(" Thank You For Using WeightLog");
				System.exit(0);

			}
			System.out.println("1. continue  2.exit");
			int num=sc.nextInt();
			if( num==1)
			{
				start();
			}
			else
			{
				System.exit(0);
			}
			break;
		case 5:
			int flag = 0;
			System.out.println("\n\n--------------WELCOME IN PAYMENT WINDOW---------------\n\n\n");
			do{
				System.out.println("\n\t\tWhat do you want to do?\n\t\tEnter number for that operation.\n"
						+ "\n\t\t1.Enter payment\n\t\t2.Update payment\n\t\t3.Delete payment\n\t\t4.Show all payments");
				System.out.print("\t\t");
				int ch=sc.nextInt();

				switch (ch) {
				case 1:
					Helper.case1();
					break;
				case 2:
					Helper.case2();
					break;

				case 3:
					Helper.case3();
					break;

				case 4:
					Helper.case4();
					break;

				default:
					throw new PaymentException("\n\t\tYou entered wrong choice");
				}
				System.out.println("\n\t\tDo you want to continue ?"
						+ "\n\t\tEnter 1 for yes\n\t\tEnter 0 for no");
				System.out.print("\t\t");
				flag=sc.nextInt();
				if(flag!=1 &&flag!=0)
					throw new PaymentException("\n\t\tYou entered wrong choice");
				else if(flag==0) {
					System.out.println("\t\tTHANK YOU!!! ");
					return;} 
			}while(flag==1);
			break;
		default:
			System.out.println("Enter valid choice");
		}
		System.out.println("---------------Thank You---------------");
	}
}
