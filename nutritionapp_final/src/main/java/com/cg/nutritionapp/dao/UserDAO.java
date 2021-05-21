package com.cg.nutritionapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.nutritionapp.exceptions.UserException;
import com.cg.nutritionapp.model.User;

public interface UserDAO {
	
	/**
	 * save() method is used for saving user in database and returns the user from database.
	 * @param user
	 * @return
	 */
	User save(User user);
	
	/**
	 * findAll() method is used to get the list of all available users from database
	 * @return
	 */
	List<User> findAll();

	/**
	 * findByUserIdentification() is used for finding any user by UserIndentification and returns the found user
	 * @param userId
	 * @return
	 */
	User findByUserIdentification(String userId);

	/**
	 * update() is used to update any entries in the database for a specific user
	 * @param user
	 * @return
	 * @throws UserException
	 */
	User update(User user) throws UserException;

	/**
	 * delete() method is used to delete any user entry from database
	 * @param uId
	 * @throws UserException
	 * @throws SQLException
	 */
	int delete (String uId) throws UserException, SQLException;


}
