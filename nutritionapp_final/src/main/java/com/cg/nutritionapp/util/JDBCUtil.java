package com.cg.nutritionapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * This class is used to provide utility for Database connection.
 * @author 
 *
 */
public class JDBCUtil {
	
	private Connection con=null;
	private PreparedStatement ps;
	
	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nutritionapp","root","siri@2526");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public PreparedStatement getPreparedStatement(String sql)
	{
		try
		{
		ps=getConnection().prepareStatement(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ps; 
	}
}
