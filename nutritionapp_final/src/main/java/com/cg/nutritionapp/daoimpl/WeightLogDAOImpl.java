package com.cg.nutritionapp.daoimpl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.cg.helper.*;
import com.cg.nutritionapp.dao.WeightLogDAO;
import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.util.JDBCUtil;

import java.sql.*;
/**
 * Fulfills all the functional requirements for your app's weightLog module.
 * Implementation of the working of module is processed here.
 * Implements all the methods of interface WeightLogDAO here.
 * Inherits properties of JDBCUtill to fulfill its database connection requirements.
 * @author 
 *
 */
public class WeightLogDAOImpl  extends JDBCUtil implements WeightLogDAO {
	JDBCUtil jdbcUtil=new JDBCUtil();
	/**
	 * Refrence of weight log which will be used to refrence to values stored in the module.
	 */
	WeightLog weightLog;
	/**
	 * save method saves new entry of the user.
	 *Its like a ragistration of new user in  app.
	 */
	public WeightLog save(WeightLog weightLog) {

		try {
			String sql="insert into weightlog(weight,created_At,userId) values(?,?,?)";
			Connection con=jdbcUtil.getConnection();
			PreparedStatement pstm=jdbcUtil.getPreparedStatement(sql);
			pstm.setDouble(1, weightLog.getWeight());
			pstm.setObject(2, weightLog.getCreated_At());
			//pstm.setObject(3, weightLog.getUpdated_At());
			pstm.setString(3, weightLog.getUserId());

			int i =pstm.executeUpdate();
			{
				if(i!=0)
				{
					System.out.println("values inserted");}

				else
				{System.out.println("values not inserted");}}


		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return weightLog;
	}

	/**
	 * This method is responsible for displaying the data to the user.
	 */
	@Override
	public List<WeightLog> findAll() {
		List<WeightLog> list=new ArrayList<>();
				try {
			Connection conn=jdbcUtil.getConnection();
			String sql="select * from weightlog ";

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				list.add(new WeightLog(rs.getInt(1),rs.getObject(2,LocalDate.class),rs.getObject(3,LocalDate.class),rs.getString(4)));
			}

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * Weight entry for the user can be updated here.
	 */
	@Override
	public WeightLog update(WeightLog weightLog)  {

		{
			if(weightLog==null)
			{
				throw new NullPointerException();  
			}
			else {

				try {
					String sql="UPDATE weightlog SET weight=?,updated_At=?  where userId=?";
					Connection con=jdbcUtil.getConnection();
					PreparedStatement pstm=jdbcUtil.getPreparedStatement(sql);

					pstm.setDouble(1, weightLog.getWeight());
					pstm.setObject(2, weightLog.getUpdated_At());
					pstm.setString(3, weightLog.getUserId());
					int i=pstm.executeUpdate();
					if(i!=0)
					{
						System.out.println("updated successfully");
					}
					else
					{
						System.out.println("update failed : invalid userid");
					}
				}

				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return weightLog;
	}

	/*
	 * User can Delete his/her weightLog here.
	 */
	@Override
	public WeightLog delete(WeightLog weightLog) {
		if(weightLog.getUserId()==null)
		{
			throw new NullPointerException();
		}
		else
		{try {
			String sql="delete from weightlog where userId=?";
			Connection con=jdbcUtil.getConnection();
			PreparedStatement pstm=jdbcUtil.getPreparedStatement(sql);

			pstm.setString(1, weightLog.getUserId());
			int i=pstm.executeUpdate();
			if(i!=0)
			{
				System.out.println("deleted successfully");
			}
			else
			{
				System.out.println("deletion failed : invalid userid");
			}


		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}



		}

		return weightLog;
	}


}
