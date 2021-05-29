package com.cg.nutritionapp.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.cg.nutritionapp.daoimpl.UserDAOImpl;
import com.cg.nutritionapp.exceptions.NoRecordException;
import com.cg.nutritionapp.model.User;
import com.cg.nutritionapp.service.UserService;


public class UserServiceImpl implements UserService{
	static UserDAOImpl dao = new UserDAOImpl();
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	


	@Override
	public void viewUser() {
		System.out.println("-----------------------------------------------");
        List<User> userList = dao.findAll();
        for(User user: userList)
        {
            displayUser(user);
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
	}
	
	@Override
	public void viewUserDietPlan() {
		System.out.println("-----------------------------------------------");
		dao.printAll();
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
	}
	
	@Override
	public void viewUserPayments() {
		System.out.println("-----------------------------------------------");
		dao.printUserPayments();
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
	}

	@Override
	public void viewUserWeightLog() {
		System.out.println("-----------------------------------------------");
		dao.printUserWeightLog();
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
	}
	@Override
	public void addUser() throws NumberFormatException, IOException {
		System.out.println("------------------------------------------------");
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Enter User Useridentification:");
        System.out.println("------------------------------------------------");
        String userId = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Enter User name:");
        System.out.println("------------------------------------------------");
        String name = br.readLine();
        System.out.println("Enter User contact:");
        System.out.println("------------------------------------------------");
        String contact = br.readLine();
        System.out.println("Enter User gender:");
        System.out.println("------------------------------------------------");
        String gender = br.readLine();
        System.out.println("Enter User Dob:");
        System.out.println("------------------------------------------------");
        String dob = br.readLine();
        System.out.println("Enter User photo:");
        System.out.println("------------------------------------------------");
        String photo = br.readLine();
        System.out.println("Enter User email:");
        System.out.println("------------------------------------------------");
        String email = br.readLine();
        System.out.println("Enter User role:");
        System.out.println("------------------------------------------------");
        String role = br.readLine();
        System.out.println("Enter User status:");
        System.out.println("------------------------------------------------");
        String status = br.readLine();
        System.out.println("Enter User weight:");
        System.out.println("------------------------------------------------");
        Double weight = Double.parseDouble(br.readLine());
        System.out.println("Enter User height:");
        System.out.println("------------------------------------------------");
        Double height = Double.parseDouble(br.readLine());
        System.out.println("Enter User Diatery Orientation:");
        System.out.println("------------------------------------------------");
        String dOrientation = br.readLine();
        System.out.println("Enter User Intensity:");
        System.out.println("------------------------------------------------");
        Double intensity = Double.parseDouble(br.readLine());
        System.out.println("Enter User goal:");
        System.out.println("------------------------------------------------");
        String goal = br.readLine();
        System.out.println("Enter User WorkOutTime:");
        System.out.println("------------------------------------------------");
        String workoutime = br.readLine();
        System.out.println("Enter User wakeup Time:");
        System.out.println("------------------------------------------------");
        String wakeUpTime = br.readLine();
        System.out.println("Enter User SleepTime:");
        System.out.println("------------------------------------------------");
        String sleepTime = br.readLine();
        System.out.println("Enter User MedicalCondition:");
        System.out.println("------------------------------------------------");
        String medicalCondition = br.readLine();
        System.out.println("Enter User AllergicTO:");
        System.out.println("------------------------------------------------");
        String allergicTo = br.readLine();
        System.out.println("Enter User login Name:");
        System.out.println("------------------------------------------------");
        String loginName = br.readLine();
        System.out.println("Enter User password:");
        System.out.println("------------------------------------------------");
        String password = br.readLine();
    
		//after user enters values, store them in a user variable
        User user = new User(userId, name, contact, gender, dob, photo, email, role, status, weight, height, dOrientation, intensity, goal, workoutime, wakeUpTime, sleepTime, medicalCondition, allergicTo, loginName, password);
        User status1 = dao.save(user);
        if(status1!=null )
        {
            System.out.println("user added successfully");
        }
        else
        {
            System.out.println("ERROR while adding user");
        }
        System.out.println("\n");
	
		
	}

	@Override
	public void updateUser() throws NumberFormatException, IOException {
System.out.println("------------------------------------------------");
        
        System.out.println("------------------------------------------------");
        System.out.println("Enter User Useridentification:");
        System.out.println("------------------------------------------------");
        String userId = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Enter User name:");
        System.out.println("------------------------------------------------");
        String name = br.readLine();
        System.out.println("Enter User contact:");
        System.out.println("------------------------------------------------");
        String contact = br.readLine();
        System.out.println("Enter User gender:");
        System.out.println("------------------------------------------------");
        String gender = br.readLine();
        System.out.println("Enter User Dob:");
        System.out.println("------------------------------------------------");
        String dob = br.readLine();
        System.out.println("Enter User photo:");
        System.out.println("------------------------------------------------");
        String photo = br.readLine();
        System.out.println("Enter User email:");
        System.out.println("------------------------------------------------");
        String email = br.readLine();
        System.out.println("Enter User role:");
        System.out.println("------------------------------------------------");
        String role = br.readLine();
        System.out.println("Enter User status:");
        System.out.println("------------------------------------------------");
        String status = br.readLine();
        System.out.println("Enter User weight:");
        System.out.println("------------------------------------------------");
        Double weight = Double.parseDouble(br.readLine());
        System.out.println("Enter User height:");
        System.out.println("------------------------------------------------");
        Double height = Double.parseDouble(br.readLine());
        System.out.println("Enter User Diatery Orientation:");
        System.out.println("------------------------------------------------");
        String dOrientation = br.readLine();
        System.out.println("Enter User Intensity:");
        System.out.println("------------------------------------------------");
        Double intensity = Double.parseDouble(br.readLine());
        System.out.println("Enter User goal:");
        System.out.println("------------------------------------------------");
        String goal = br.readLine();
        System.out.println("Enter User WorkOutTime:");
        System.out.println("------------------------------------------------");
        String workoutime = br.readLine();
        System.out.println("Enter User wakeup Time:");
        System.out.println("------------------------------------------------");
        String wakeUpTime = br.readLine();
        System.out.println("Enter User SleepTime:");
        System.out.println("------------------------------------------------");
        String sleepTime = br.readLine();
        System.out.println("Enter User MedicalCondition:");
        System.out.println("------------------------------------------------");
        String medicalCondition = br.readLine();
        System.out.println("Enter User AllergicTO:");
        System.out.println("------------------------------------------------");
        String allergicTo = br.readLine();
        System.out.println("Enter User login Name:");
        System.out.println("------------------------------------------------");
        String loginName = br.readLine();
        System.out.println("Enter User password:");
        System.out.println("------------------------------------------------");
        String password = br.readLine();
        //after user enters values, store them in a user variable
        User user = new User(userId, name, contact, gender, dob, photo, email, role, status, weight, height, dOrientation, intensity, goal, workoutime, wakeUpTime, sleepTime, medicalCondition, allergicTo, loginName, password);
        User status1 = dao.update(user);
        if(status1!=null )
        {
            System.out.println("user updated successfully");
        }
        else
        {
            System.out.println("ERROR while updating user");
        }
        System.out.println("\n");
	
		
	}

	@Override
	public void deleteUser() throws IOException, SQLException {
		System.out.println("------------------------------------------------");
        System.out.println("Enter user ID:");
        System.out.println("------------------------------------------------");
        String userId = br.readLine();
        int status = dao.delete(userId);
        if(status == 1 )
        {
            System.out.println("User deleted successfully");
        }
        else
        {
            System.out.println("ERROR while deleting user");
        }
        System.out.println("\n");
		
		
	}

	@Override
	public void searchUser() throws IOException {
		System.out.println("------------------------------------------------");
        System.out.println("Enter User UserIdentification:");
        System.out.println("------------------------------------------------");
        String userId =  br.readLine();
        User user = dao.findByUserIdentification(userId);
        displayUser(user);
        System.out.println("\n");
		
	}

	@Override
	public void displayUser(User user){
		System.out.println("User ID: "+user.getId());
        System.out.println("User Useridentification: "+user.getUserIdentification());
        System.out.println("User Name : "+user.getName());
        System.out.println("User Contact nO: "+user.getContact());
        System.out.println("User Gender: "+user.getGender());
        System.out.println("User DOB: "+user.getDob());
        System.out.println("User Photo: "+user.getPhoto());
        System.out.println("User Email: "+user.getEmail());
        System.out.println("User Role: "+user.getRole());
        System.out.println("User Status: "+user.getStatus());
        System.out.println("User Weight: "+user.getWeight());
        System.out.println("User Height: "+user.getHeight());
        System.out.println("User Diatery Orientation: "+user.getDiateryOrientation());
        System.out.println("User Intensity: "+user.getIntensity());
        System.out.println("User Goal: "+user.getGoal());
        System.out.println("User WorkOuTtIME: "+user.getWorkOutTime());
        System.out.println("User WakeUpTime: "+user.getWakeUpTime());
        System.out.println("User SleepTime: "+user.getSleepTime());
        System.out.println("User MedicalCondition: "+user.getMedicalConditon());
        System.out.println("User Allergic To: "+user.getAllergicTo());
        System.out.println("User Login name: "+user.getLoginName());
        System.out.println("User Password: "+user.getPassword());
        
        System.out.println("\n");
		
	}
	
	

}
