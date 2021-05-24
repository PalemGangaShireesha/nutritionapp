package com.cg.nutritionapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.nutritionapp.dao.NutritionPlanDAO;
import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.util.JDBCUtil;

/**
 * All the CRUD operations are performed in this class.
 * @author 
 *
 */

public class NutritionPlanDAOImpl extends JDBCUtil implements NutritionPlanDAO {

	@Override
	public NutritionPlan save(NutritionPlan nutritionPlan) {
		NutritionPlan nutritionPlanFromDB=null;

		if(nutritionPlan==null)
		{
			throw new NullPointerException();
		}
		else
		{
			saveNutritionPlan(nutritionPlan);
			nutritionPlanFromDB = fetchNutritionPlanFromDB(nutritionPlan, nutritionPlanFromDB);
		}
		return nutritionPlanFromDB;
	}

	private NutritionPlan fetchNutritionPlanFromDB(NutritionPlan nutritionPlan, NutritionPlan nutritionPlanFromDB) {
		String sql="select * from nutritionplans where name =?";
		PreparedStatement ps=getPreparedStatement(sql);
		try {
			ps.setString(1, nutritionPlan.getName());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				nutritionPlanFromDB=new NutritionPlan();										
				nutritionPlanFromDB.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nutritionPlanFromDB;
	}

	private void saveNutritionPlan(NutritionPlan nutritionPlan) {
		try
		{
			String sql="insert into nutritionplans(name,planDescription,created_at,updated_at,price) values(?,?,?,?,?)";
			PreparedStatement ps=getPreparedStatement(sql);
			//ps.setInt(1, nutritionPlan.getId());
			ps.setString(1, nutritionPlan.getName());
			ps.setString(2, nutritionPlan.getPlanDescription());
			ps.setDate(3,nutritionPlan.getCreated_At());
			ps.setDate(4,nutritionPlan.getUpdated_At());
			ps.setLong(5,nutritionPlan.getPrice());
			ps.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<NutritionPlan> findAll() throws NutritionPlanException{
		List<NutritionPlan> nutritionPlan=new ArrayList<NutritionPlan>();
		
		try
		{
			String sql="select * from nutritionplans";
			PreparedStatement ps=getPreparedStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				nutritionPlan.add(new NutritionPlan(rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getLong(6)));
				
			}
			
			return nutritionPlan;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return nutritionPlan;
	}

	@Override
	public NutritionPlan update(NutritionPlan nutritionPlan) {
		try
		{
			String sql="update nutritionplans set planDescription=?,updated_at=? where name=?";
			PreparedStatement ps=getPreparedStatement(sql);
			ps.setString(3, nutritionPlan.getName());
			ps.setDate(2, nutritionPlan.getUpdated_At());
			ps.setString(1, nutritionPlan.getPlanDescription());
			ps.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return nutritionPlan;
	}

	@Override
	public NutritionPlan delete(NutritionPlan nutritionPlan) {

		if(nutritionPlan==null)
		{
			throw new NullPointerException();
		}
		else
		{
			try
			{
				String sql="delete from nutritionplans where name=?";
				PreparedStatement ps=getPreparedStatement(sql);
				ps.setString(1, nutritionPlan.getName());
				ps.execute();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return nutritionPlan;
	}
}
