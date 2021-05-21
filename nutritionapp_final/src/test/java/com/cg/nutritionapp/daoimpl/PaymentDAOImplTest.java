package com.cg.nutritionapp.daoimpl;

import static org.junit.Assert.*;


import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.cg.nutritionapp.daoimpl.PaymentDAOImpl;
import com.cg.nutritionapp.exceptions.DuplicateIdException;
import com.cg.nutritionapp.exceptions.NoRecordException;
import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;
/**
 * This class is use to test all operations of Payment Interface
 * @author 
 *
 */
public class PaymentDAOImplTest {
	private PaymentDAOImpl paymentDAO;
	Payment payments1;
	@Before
	public void setup() {
		paymentDAO = new PaymentDAOImpl();
	}

	@Test
	public void test_save_GivenPaymentObject_Should_Insert_Record() throws PaymentException {
		payments1=new Payment(1,3000,0,(java.time.LocalDate.now()),null,142,11);
		boolean result =paymentDAO.save(payments1);
		assertEquals(true, result);
	}
	//passed
	@Test
	public void test_update_GivenPaymentObject_Should_Update_Record() throws PaymentException{
		payments1=new Payment(1,2000,0,(java.time.LocalDate.now()),(java.time.LocalDate.now()),115,14);
		Payment paymentTest=paymentDAO.update(payments1);
		assertEquals(payments1,paymentTest);
	}
	//passed
	@Test
	public void test_findAll_Check_ListIsEmpty_Should_Throw_PaymentException() throws PaymentException{
		ArrayList<Payment> paymentTest=paymentDAO.findAll();
		ArrayList<Payment> list=new ArrayList<Payment>();
		list = paymentDAO.findAll();
		assertNotNull(paymentTest);
		if(paymentTest==null) throw new PaymentException("There is no Payments available in DB");
	}
	@Test
	public void test_findAll_GivenPaymentObject_Should_Return_All_Records(){
		ArrayList<Payment> paymentTest=paymentDAO.findAll();
		ArrayList<Payment> list=new ArrayList<Payment>();
		list = paymentDAO.findAll();
		assertNotNull(paymentTest);
	}
	@Test
	public void test_delete_GivenPaymentObject_Should_delete_Record() throws PaymentException{
		payments1=new Payment(1,1000.00,0.00,(java.time.LocalDate.now()),(java.time.LocalDate.now()),128,11);
		Payment paymentTest=paymentDAO.delete(payments1);
		assertEquals(payments1,paymentTest);
	}
	
}
