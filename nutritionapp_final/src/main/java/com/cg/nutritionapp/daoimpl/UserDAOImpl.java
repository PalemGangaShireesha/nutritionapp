package com.cg.nutritionapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.nutritionapp.dao.UserDAO;
import com.cg.nutritionapp.exceptions.NoRecordException;
import com.cg.nutritionapp.exceptions.UserException;
import com.cg.nutritionapp.model.User;
import com.cg.nutritionapp.util.JDBCUtil;



public class UserDAOImpl implements UserDAO {
	JDBCUtil jdbcUtil = new JDBCUtil();

	@Override
	public User save(User user) {
		if (user == null)
		{
			return null;
		}
		else
		{
			saveUser(user);
			userFromDb(user);
			return user;
		}
	}

	private void userFromDb(User user) {
		String sql="select * from users";
		
		PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
		try
		{
			pstmt.execute();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void saveUser(User user) {
		try {
			String sql = "Insert into users(userIdentification, name, contact, gender, dob, photo, email, role, status, weight, height, diateryOrientation, intensity, goal, workOutTime, WakeUpTime, sleepTime, medicalCondition, allergicTo, loginName, password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
			pstmt.setString(1, user.getUserIdentification());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getContact());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getDob());
			pstmt.setString(6, user.getPhoto());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getRole());
			pstmt.setString(9, user.getStatus());
			pstmt.setDouble(10, user.getWeight());
			pstmt.setDouble(11, user.getHeight());
			pstmt.setString(12, user.getDiateryOrientation());
			pstmt.setDouble(13, user.getIntensity());
			pstmt.setString(14, user.getGoal());
			pstmt.setString(15, user.getWorkOutTime());
			pstmt.setString(16, user.getWakeUpTime());
			pstmt.setString(17, user.getSleepTime());
			pstmt.setString(18, user.getMedicalConditon());
			pstmt.setString(19, user.getAllergicTo());
			pstmt.setString(20, user.getLoginName());
			pstmt.setString(21, user.getPassword());
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	@Override
	public User findByUserIdentification(String userId){
		User u = null;  
		try{ 
			String sql = "select * from users where userIdentification=(?)";
			PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				u = new User();
				u.setId(rs.getLong("id"));
				u.setUserIdentification(rs.getString("userIdentification"));
				u.setName(rs.getString("name"));
				u.setContact(rs.getString("contact"));
				u.setGender(rs.getString("gender"));
				u.setDob(rs.getString("dob"));
				u.setPhoto(rs.getString("photo"));
				u.setEmail(rs.getString("email"));
				u.setRole(rs.getString("role"));
				u.setStatus(rs.getString("status"));
				u.setWeight(rs.getDouble("weight"));
				u.setHeight(rs.getDouble("height"));
				u.setDiateryOrientation(rs.getString("diateryOrientation"));
				u.setIntensity(rs.getDouble("intensity"));
				u.setGoal(rs.getString("goal"));
				u.setWorkOutTime(rs.getString("workOutTime"));
				u.setWakeUpTime(rs.getString("wakeUpTime"));
				u.setSleepTime(rs.getString("sleepTime"));
				u.setMedicalConditon(rs.getString("medicalCondition"));
				u.setAllergicTo(rs.getString("allergicTo"));
				u.setLoginName(rs.getString("loginName"));
				u.setPassword(rs.getString("password"));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return u;  
	}

	@Override
	public User update(User user)  {
		try {
		String sql = "update users set name=?, contact=?, gender=?, dob=?, photo=?, email=?, role=?, status=?, weight=?, height=?, diateryOrientation=?, intensity=?, goal=?, workOutTime=?, WakeUpTime=?, sleepTime=?, medicalCondition=?, allergicTo=?, loginName=?, password=? where UserIdentification=?";
		PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
		//userUpdate(user, pstmt);
		//return user;

	//private void userUpdate(User user, PreparedStatement pstmt) {
			pstmt.setString(1, user.getName());

			pstmt.setString(2, user.getContact());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getDob());
			pstmt.setString(5, user.getPhoto());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getRole());
			pstmt.setString(8, user.getStatus());
			pstmt.setDouble(9, user.getWeight());
			pstmt.setDouble(10, user.getHeight());
			pstmt.setString(11, user.getDiateryOrientation());
			pstmt.setDouble(12, user.getIntensity());
			pstmt.setString(13, user.getGoal());
			pstmt.setString(14, user.getWorkOutTime());
			pstmt.setString(15, user.getWakeUpTime());
			pstmt.setString(16, user.getSleepTime());
			pstmt.setString(17, user.getMedicalConditon());
			pstmt.setString(18, user.getAllergicTo());
			pstmt.setString(19, user.getLoginName());
			pstmt.setString(20, user.getPassword());
			pstmt.setString(21, user.getUserIdentification());
			pstmt.execute();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
}
	

	@Override
	public int delete(String uId) throws SQLException {


		int status=0;  
        try{ 
            PreparedStatement ps=jdbcUtil.getPreparedStatement("delete from users where UserIdentification=?");  
            ps.setString(1,uId);  
            status=ps.executeUpdate();  

        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
	}

	@Override
	public List<User> findAll() {
		 List<User> list=new ArrayList<User>();  
	      
		    try{  
		    	String sql = "select * from users";
		        PreparedStatement ps=jdbcUtil.getPreparedStatement(sql);  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            User u=new User();  
		            u.setId(rs.getLong("id"));
					u.setUserIdentification(rs.getString("userIdentification"));
					u.setName(rs.getString("name"));
					u.setContact(rs.getString("contact"));
					u.setGender(rs.getString("gender"));
					u.setDob(rs.getString("dob"));
					u.setPhoto(rs.getString("photo"));
					u.setEmail(rs.getString("email"));
					u.setRole(rs.getString("role"));
					u.setStatus(rs.getString("status"));
					u.setWeight(rs.getDouble("weight"));
					u.setHeight(rs.getDouble("height"));
					u.setDiateryOrientation(rs.getString("diateryOrientation"));
					u.setIntensity(rs.getDouble("intensity"));
					u.setGoal(rs.getString("goal"));
					u.setWorkOutTime(rs.getString("workOutTime"));
					u.setWakeUpTime(rs.getString("wakeUpTime"));
					u.setSleepTime(rs.getString("sleepTime"));
					u.setMedicalConditon(rs.getString("medicalCondition"));
					u.setAllergicTo(rs.getString("allergicTo"));
					u.setLoginName(rs.getString("loginName"));
					u.setPassword(rs.getString("password"));
		            list.add(u);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;  
	}

	public void printAll() {
		// TODO Auto-generated method stub
	    try{  
	    	String sql = "select * from users left join Dietplan ON users.userIdentification = Dietplan.userId";
	        PreparedStatement ps=jdbcUtil.getPreparedStatement(sql);  
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	        	System.out.println("user id " + rs.getLong("id"));
				System.out.println("user identification " + rs.getString("userIdentification"));
				System.out.println("user contact " + rs.getString("contact"));
				System.out.println("user gender " + rs.getString("gender"));
				System.out.println("user date of birth " + rs.getString("dob"));
				System.out.println("user image link " + rs.getString("photo"));
				System.out.println("user email id " + rs.getString("email"));
				System.out.println("user role " + rs.getString("role"));
				System.out.println("user status " + rs.getString("status"));
				System.out.println("user weight " + rs.getDouble("weight"));
				System.out.println("user height " + rs.getDouble("height"));
				System.out.println("user dietary orientation " + rs.getString("diateryOrientation"));
				System.out.println("user intensity " + rs.getDouble("intensity"));
				System.out.println("user goal " + rs.getString("goal"));
				System.out.println("user workout time " + rs.getString("workOutTime"));
				System.out.println("user wakeup time " + rs.getString("wakeUpTime"));
				System.out.println("user sleep time " + rs.getString("sleepTime"));
				System.out.println("user medical condition " + rs.getString("medicalCondition"));
				System.out.println("user is allergic to " + rs.getString("allergicTo"));
				System.out.println("login name of user " + rs.getString("loginName"));
				System.out.println("password " + rs.getString("password"));
				System.out.println("dietplan id " + rs.getLong("id"));
				System.out.println("user diet slot " + rs.getString("slots"));
				System.out.println("user food type " + rs.getString("foodType"));
				System.out.println("diet protein ratio " + rs.getDouble("proteinRatio"));
				System.out.println("dietfat ratio " + rs.getDouble("fatRatio"));
				System.out.println("diet carbs ratio " + rs.getDouble("carbsRatio"));
				System.out.println("toal diet intake " + rs.getDouble("total"));
				System.out.println("---------------------------------------");
	        }  
	    }catch(Exception e){System.out.println(e);}
	}

	public void printUserPayments() {
		// TODO Auto-generated method stub
		try{  
	    	String sql = "select * from users inner join payments ON users.userIdentification = payments.userId";
	        PreparedStatement ps=jdbcUtil.getPreparedStatement(sql); 
	        ArrayList<Long> ids = new ArrayList<Long>();
	        Long currId;
	        boolean idVisited;
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	        	currId = rs.getLong("id");
	        	idVisited = ids.contains(currId);
	        	if (!idVisited) {
	        		ids.add(currId);
	        		//System.out.println("user id " + currId);
	        		System.out.println("user id " + rs.getString("userIdentification"));
					System.out.println("user contact " + rs.getString("contact"));
					System.out.println("user gender " + rs.getString("gender"));
					System.out.println("user email id " + rs.getString("email"));
					System.out.println("login name of user " + rs.getString("loginName"));
					System.out.println("password " + rs.getString("password"));
					System.out.println("\nPayments made by user:");
	        	}
				System.out.println("\nPayment id " + rs.getLong("payments.id"));
				System.out.println("Payment " + rs.getDouble("payment"));
				System.out.println("Created on " + rs.getDate("created_At"));
				System.out.println("Payment last updated on " + rs.getDate("updated_At"));
				System.out.println("Payment made for plan- " + rs.getLong("planId"));
				if (idVisited) System.out.println("=====================================");
	        }  
	    }catch(Exception e){System.out.println(e);}
	}

	public void printUserWeightLog() {
		// TODO Auto-generated method stub
		try{  
	    	String sql = "select * from users inner join weightlog ON users.userIdentification = weightlog.userId";
	        PreparedStatement ps=jdbcUtil.getPreparedStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	        	System.out.println("user id " + rs.getString("userIdentification"));
				System.out.println("user contact " + rs.getString("contact"));
				System.out.println("user gender " + rs.getString("gender"));
				System.out.println("user email id " + rs.getString("email"));
				System.out.println("login name of user " + rs.getString("loginName"));
				System.out.println("password " + rs.getString("password"));
				System.out.println("User weight " + rs.getInt("weight"));
				if (rs.getDate("updated_At") == null)
					System.out.println("Weight last updated on " + rs.getDate("created_At"));
				else
					System.out.println("Weight last updated on " + rs.getDate("updated_At"));
				System.out.println("=====================================");
	        }  
	    }catch(Exception e){System.out.println(e);}
	}
}