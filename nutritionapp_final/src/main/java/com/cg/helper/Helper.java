package com.cg.helper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.nutritionapp.dao.PaymentDAO;
import com.cg.nutritionapp.daoimpl.PaymentDAOImpl;
import com.cg.nutritionapp.exceptions.DuplicateIdException;
import com.cg.nutritionapp.exceptions.NoRecordException;
import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;
/**
 * This is an Helper class
 * @author admin
 *
 */
public class Helper {
	Long id;
	Double payment;
	Double discount;
	Date created_At;
	Date updated_At;
	Long planId;
	Long userId;
	static LocalDate localdate =java.time.LocalDate.now();
	static PaymentDAOImpl obj1=new PaymentDAOImpl();
	static Scanner sc=new Scanner(System.in);

	public static void case1() throws DuplicateIdException,PaymentException {
		System.out.print("\t\tEnter USER ID: ");
		long userId = sc.nextLong();
		System.out.print("\t\tEnter PLAN ID: ");
		long planId = sc.nextLong();
		System.out.print("\t\tEnter PAYMENT: ");
		double payment=sc.nextDouble();
		Payment payments=new Payment(1, payment,PaymentDAOImpl.DISCOUNT, localdate, null, userId, planId);
		obj1.save(payments);
	}


	public static void case2() throws NoRecordException, PaymentException {
		System.out.print("\t\tEnter USER ID: ");
		long userId=sc.nextLong();
		System.out.print("\t\tENTER NEW PLAN ID FOR UPDATION: ");
		long planId = sc.nextLong();
		System.out.print("\t\tENTER PAYMENT ACCORDING TO YOUR UPDATED PLAN ID: ");
		double payment=sc.nextDouble();
		Payment payments=new Payment(1, payment,PaymentDAOImpl.DISCOUNT, localdate, localdate, userId, planId);
		obj1.update(payments);



	}
	public static void case3() throws PaymentException {
		System.out.println("\t\tDeletion of payment is not applicable.");
		/*	long userId=sc.nextLong();
		Payment payments=new Payment(1, payment,PaymentDAOImpl.DISCOUNT, localdate, localdate, userId, planId);
		obj1.delete(payments);
		 */
	}
	public static void case4() {
		System.out.println("\t\tTHESE ARE ALL PAYMENT RECORDS");
		List<Payment> list=new ArrayList<Payment>();
		list=obj1.findAll();
		for(Payment p:list) {
			System.out.print("\t\t");
			System.out.println(p);
		}

	}

}
