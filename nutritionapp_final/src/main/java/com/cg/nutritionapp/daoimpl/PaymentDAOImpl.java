package com.cg.nutritionapp.daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cg.nutritionapp.dao.PaymentDAO;
import com.cg.nutritionapp.exceptions.DuplicateIdException;
import com.cg.nutritionapp.exceptions.NoRecordException;
import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;
import com.cg.nutritionapp.util.JDBCUtil;
/**
 * This class is use for implementation of operations of Payment Interface
 * @author 
 *
 */
public class PaymentDAOImpl extends JDBCUtil implements PaymentDAO
{
	
	public static final int DISCOUNT=0;
	@Override
	public Boolean save(Payment payments) {
		boolean result = false;
		try
		{result = savePayment(payments);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	@Override
	public Payment update(Payment payments) {
		try {
			if(payments.getUserId()==0) throw new NoRecordException("zero value of user id ");
			updatePayment(payments);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return payments;
	}
	
	@Override
	public Payment delete(Payment payments) {
		try {	deletePayment(payments);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return payments;
		
	}
	

	@Override
	public ArrayList<Payment> findAll() {
		ArrayList<Payment> list=new ArrayList<Payment>();
		try {
			showAllPayments(list);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}



	private void showAllPayments(ArrayList<Payment> list)
			throws SQLException, ClassNotFoundException, PaymentException {
		String sql="select * from payments";
		PreparedStatement ps=getPreparedStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(new Payment(rs.getLong(1),rs.getDouble(2),rs.getDouble
					(3),rs.getObject(4,LocalDate.class),rs.getObject(5,LocalDate.class),rs.getLong(6),rs.getLong(7)));

		}
	}
	private boolean savePayment(Payment payments) throws SQLException, ClassNotFoundException, DuplicateIdException {
		boolean result;
		String result1;
		String sql="insert into payments (id, payment,discount,created_At,userId,planId)"
				+ " values(?,?,0,?,?,?)";
		PreparedStatement ps=getPreparedStatement(sql);
		//changed
		ps.setDouble(1, payments.getId());
		ps.setDouble(2, payments.getPayment());
		ps.setDate(3,java.sql.Date.valueOf(java.time.LocalDate.now()));
		ps.setLong(4,payments.getUserId());
		ps.setLong(5,payments.getPlanId());
		int i=ps.executeUpdate();
		if(i!=0) System.out.println("\t\tPayment inserted");
		else throw new DuplicateIdException("\n\t\tYou are trying to enter duplicate UserId");
		result = true;
		return result;
	}
	private void updatePayment(Payment payments) throws SQLException, ClassNotFoundException, NoRecordException {
		String sql="update payments set planId=(?),payment=(?),updated_At=(?) where userId=(?)";
		PreparedStatement ps=getPreparedStatement(sql);
		ps.setLong(1,payments.getPlanId());
		ps.setDouble(2,payments.getPayment());
		ps.setDate(3,java.sql.Date.valueOf(java.time.LocalDate.now()));
		ps.setLong(4,payments.getUserId());
		int i=ps.executeUpdate();
		if(i!=0) System.out.println("\t\tPayment updated");
		else throw new NoRecordException("\n\t\tThere is no Record for this userId");
	    
	}

	private void deletePayment(Payment payments) throws SQLException, ClassNotFoundException {
		String sql="delete from payments where userId=(?)";
		PreparedStatement ps=getPreparedStatement(sql);
		ps.setLong(1,payments.getUserId());
		int i=ps.executeUpdate();
		if(i!=0) System.out.println("\t\tPayment deleted");
		else System.out.println("\t\tPayment not deleted");
	}

	public boolean save(boolean payment) {
		// TODO Auto-generated method stub
		return false;
	}

}
