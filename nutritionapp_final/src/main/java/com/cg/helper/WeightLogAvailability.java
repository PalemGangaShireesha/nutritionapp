package com.cg.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.nutritionapp.util.JDBCUtil;
import com.cg.nutritionapp.util.MenuUtil;

public class WeightLogAvailability {
	
	/**
	 * This Method checks whether your userid for weightlog exists in database or not.
	 * Restricts Duplication of userid values.
	 * @author 
	 */
	MenuUtil menuUtil=new MenuUtil();
	/**
	 * This Method checks weather given userid by user already registered with the App.
	 * If it does exist you cannot ragister for the same.
	 * @param userId
	 */
	public void checkUserIdSave(String userId) throws Exception
	{
	    try
	    {
	    	JDBCUtil jdbcUtil = new JDBCUtil();
	    	String sql="select * from weightlog where userid=?";
	    	Connection conn=jdbcUtil.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,userId);
	        ResultSet rs=pstmt.executeQuery();
	        if(rs.next())
	        {
	        	System.out.println("This userId Already Exists. TRY AGAIN");
	        	menuUtil.start();
	        }
	        else
	        {
	        	
	        	System.out.println("This userId Available for Save");
	        }
	        
	     }

	     catch (SQLException e) 
	     {
	        System.out.println("SQL Exception: "+ e.toString());
	     }
	 }
	
	/**
	 * This method checks If the userId entered by user is ragistered with app.
	 * If ragistered , will process your display,update or delete request.
	 * If not, will send you to menu again.
	 * @param userId
	 */
	
	public void checkUserIdExists(String userId) throws Exception
	{
	    try
	    {
	    	JDBCUtil jdbcUtil = new JDBCUtil();
	    	String sql="select * from weightlog where userid=?";
	    	Connection conn=jdbcUtil.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,userId);
	        ResultSet rs=pstmt.executeQuery();
	        if(rs.next())
	        {
	        	System.out.println("This user id exists in database.  ");
	        	
	        }
	        else
	        {
	        	System.out.println("This user id doesn't exist");
	        	menuUtil.start();
	        }
	        
	     }

	     catch (SQLException e) 
	     {
	        System.out.println("SQL Exception: "+ e.toString());
	     }
	 }

}

