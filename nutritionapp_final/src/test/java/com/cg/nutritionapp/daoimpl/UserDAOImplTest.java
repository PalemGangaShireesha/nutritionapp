package com.cg.nutritionapp.daoimpl;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.nutritionapp.dao.UserDAO;
import com.cg.nutritionapp.daoimpl.UserDAOImpl;
import com.cg.nutritionapp.exceptions.UserException;
import com.cg.nutritionapp.model.User;


/**
 * Test class to test UserDaoImpl
 * @author
 *
 */
public class UserDAOImplTest {
	UserDAO userDao;


	@Before
	public void setUp()
	{

		userDao = new UserDAOImpl();

	}

	@Test
	public void test_save_GivenNullUserRefrence_ShouldReturnNull() {

		User user= null;
		User savedUser = userDao.save(user);
		assertNull(savedUser);
	}

	@Test
	public void test_save_GivenUserWithVanshikaName_ShouldReturnVanshika() {
		User user = new User("","Vanshika", "7987230712", "female", "21/09/1998", "abc.jpg", "vanshika@test", "customer", "active", (double) 52, (double)5.2, "loose weight", (double)6, "loose 5KG", "2 hours", "6:30AM", "11:30PM", "None", "None", "vanshika123", "vanshika123456");
		User savedUser = userDao.save(user);
		assertEquals("Vanshika", savedUser.getName());
	}


	@Test
	public void test_findAll_ShouldReturnListOfUsers() {
		List<User> user = userDao.findAll();
		assertNotNull(user);
	}

	@Test
	public void test_findByUserIdentification_GivenUserId_ShouldReturnUserObject() {
		String userId = "vanshika123";
		User foundUser = userDao.findByUserIdentification(userId);
		assertNotNull(foundUser);
	}

	@Test
	public void test_update_GivenUserWithUpdate_ShouldReturnUpdatedUser() throws UserException {
		User user = new User("alice123","alice", "7987230712", "female", "21/09/1998", "abc.jpg", "alice@test", "customer", "active", (double) 52, (double)5.2, "loose weight", (double)6, "loose 5KG", "2 hours", "6:30AM", "11:30PM", "None", "None", "alice123", "alice123456");
		User updateUser = userDao.update(user);
		assertNotNull(updateUser);
	}

	@Test
	public void tets_delete_GivenUser_ShouldDeleteUser() throws UserException, SQLException
	{

		String uL = "bob123";
		userDao.delete(uL);
		assertNotNull(uL);

	}


}
