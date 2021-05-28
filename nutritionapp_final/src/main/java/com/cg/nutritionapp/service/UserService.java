package com.cg.nutritionapp.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.nutritionapp.model.User;


public interface UserService {

	/**
	 * used for showing the users which are already stored in db
	 */
	public void viewUser();


	/**
	 * This method is used for adding users
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void addUser() throws NumberFormatException, IOException;

	/**
	 * used for updating users
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void updateUser() throws NumberFormatException, IOException;

	/**
	 * Used for deleting a entry in users table
	 * @throws IOException
	 * @throws SQLException 
	 */
	public void deleteUser() throws IOException, SQLException;

	/**
	 * used to search a user by id
	 * @throws IOException
	 */
	public void searchUser() throws IOException;


	/**
	 * used to display user
	 * @param@Override
	 user
	 */
	public void displayUser(User user);


	void viewUserDietPlan();
}
