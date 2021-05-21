package com.cg.nutritionapp.util;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;

import com.cg.nutritionapp.util.JDBCUtil;

public class JDBCUtilTest {
	private JDBCUtil jdbcUtil=null;

	@Before
	public void setUp()
	{
		jdbcUtil=new JDBCUtil();
	}

	@Test
	public void test_getConnection_ShouldReturnConnectionObject() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method=JDBCUtil.class.getDeclaredMethod("getConnection");
		method.setAccessible(true);
		Connection con=(Connection) method.invoke(jdbcUtil);
		assertTrue(con!=null);
	}

	@Test
	public void test_prepareStatement_ShouldReturnPreparedStatementObject()
	{
		PreparedStatement ps=jdbcUtil.getPreparedStatement("insert into nutritionplans values(name,plan_description,created_at,updated_at,price");
		assertTrue(ps!=null);
	}
}
