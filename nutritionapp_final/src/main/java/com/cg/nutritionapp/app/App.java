package com.cg.nutritionapp.app;

import com.cg.nutritionapp.util.MenuUtil;

/**
 * This is the main class from where the nutrition plan module begins.
 *
 */
public class App 
{
	public static void main( String[] args ) throws Exception
	{
		MenuUtil menuUtil=new MenuUtil();
		menuUtil.start();
	}
}
