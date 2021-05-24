package com.cg.nutritionapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cg.nutritionapp.dao.DietPlanDAO;
import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.util.JDBCUtil;

/**
 * It is the only implementation of DietPlanDAO interface.
 */

public class DietPlanDAOImpl implements DietPlanDAO{
	JDBCUtil jdbcUtil=new JDBCUtil();

	/**
	 * it is the implementation of method save() of  DietPlanDAO interface
	 */
	@Override
	public DietPlan save(DietPlan dietPlan) throws DietPlanException {
		if(dietPlan==null)
		{
			return null;
		}
		if(dietPlan.getUserId().equals("") || dietPlan.getSlots().equals("") || dietPlan.getFoodType().equals("")) {
			throw new DietPlanException("Enter user id");
		}
		try {
			
			String sql = "insert into dietPlan (id,userId,slots,foodType,proteinRatio,fatRatio,carbsRatio,total) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=jdbcUtil.getPreparedStatement(sql);
			preparedStatement.setLong(1, dietPlan.getId());
			preparedStatement.setString(2, dietPlan.getUserId());
			preparedStatement.setString(3, dietPlan.getSlots());
			preparedStatement.setString(4, dietPlan.getFoodType());
			preparedStatement.setDouble(5, dietPlan.getProteinRatio());
			preparedStatement.setDouble(6, dietPlan.getFatRatio());
			preparedStatement.setDouble(7, dietPlan.getCarbsRatio());
			preparedStatement.setDouble(8, dietPlan.getTotal());
			int i=preparedStatement.executeUpdate();
			if(i!=0)
			{
				System.out.println("DietPlan is inserted");
			}
			else
			{
				System.out.println("DietPlan is not inserted");
			}
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());		
			}
		return dietPlan;

		
	}
	
	
	/**
	 * it is the implementation of method update() update slots and foodtype of  DietPlanDAO interface
	 */
	public DietPlan update(long id, String slots, String foodType) throws DietPlanException {
		DietPlan dietPlan=new DietPlan();
		if((slots==null) || (foodType==null)) {
			throw new DietPlanException("Enter the slots and foodType");
		}
		try {
			String query="update dietPlan set slots=?,foodType=? where id=?";
			PreparedStatement preparedStatement=(PreparedStatement) jdbcUtil.getPreparedStatement(query);
			preparedStatement.setString(1, slots);
			preparedStatement.setString(2, foodType);
			preparedStatement.setLong(3, id);
			int i=preparedStatement.executeUpdate();
			if(i!=0) {

				query="select * from dietPlan where id=(?)";
				PreparedStatement preparedStatement1=jdbcUtil.getPreparedStatement(query);
				preparedStatement1.setLong(1, id);
				ResultSet rs=preparedStatement1.executeQuery();  

				while(rs.next()){
					dietPlan.setId(rs.getLong(1));
					dietPlan.setUserId(rs.getString(2));
					dietPlan.setSlots(rs.getString(3));
					dietPlan.setFoodType(rs.getString(4));
					dietPlan.setProteinRatio(rs.getDouble(5));
					dietPlan.setFatRatio(rs.getDouble(6));
					dietPlan.setCarbsRatio(rs.getDouble(7));
					dietPlan.setTotal(rs.getDouble(8));
		
				}


				return dietPlan ;
			}else
				System.out.println("No Diet Plan was found with entered id.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	
	/**
	 * it is the implementation of method findAll() records of  DietPlanDAO interface
	 */
	@Override
	public List<DietPlan> findAll() {
		List<DietPlan> list=new ArrayList<DietPlan>();
		try {
			String sql="select * from dietPlan";
			PreparedStatement preparedStatement=jdbcUtil.getPreparedStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();  

			while(rs.next()){  
				list.add(new DietPlan(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}


	/**
	 * it is the implementation of method deleteDietPlanById() delete dietplan by id of  DietPlanDAO interface
	 */
	public DietPlan deleteDietPlanById(long id) {
		DietPlan dietPlan=new DietPlan();
		try {
			String query="select * from dietPlan where id=?";
			PreparedStatement preparedStatement=jdbcUtil.getPreparedStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet rs=preparedStatement.executeQuery(); 
			if(rs.next()==false)
				System.out.println("No dietPlan found with entered id");
			rs.beforeFirst();

			while(rs.next()){  
				dietPlan.setId(rs.getLong(1));
				dietPlan.setUserId(rs.getString(2));
				dietPlan.setSlots(rs.getString(3));
				dietPlan.setFoodType(rs.getString(4));
				dietPlan.setProteinRatio(rs.getDouble(5));
				dietPlan.setFatRatio(rs.getDouble(6));
				dietPlan.setCarbsRatio(rs.getDouble(7));
				dietPlan.setTotal(rs.getDouble(8));

			}
			query="delete from dietPlan where id=?";
			PreparedStatement preparedStatement1=jdbcUtil.getPreparedStatement(query);

			preparedStatement1.setLong(1, id);
			int i=preparedStatement1.executeUpdate();
			if(i!=0) {
				return dietPlan;
			}else {
				System.out.println("No dietPlan has been deleted.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


		}
