package com.automation.testscripts.pageobjectmodel;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.framework;
import com.automation.screens.Excelhelper;
import com.automation.screens.addemployees_screen;
import com.automation.screens.loginpage;


public class TC_03_createEmployee extends framework{
	
@Test(dataProvider = "getdata")
public void createEmployee(String username,String password,String firstname,String lastname) throws Exception {
	driver.get("https://opensource-demo.orangehrmlive.com/");

	loginpage loginpage = new loginpage(driver);
	loginpage.login(username, password);
	
	addemployees_screen addemployees_screen = new addemployees_screen(driver);
	addemployees_screen.addemployee(firstname, lastname);

}	

@DataProvider
public String[][] getdata() throws Exception  {
	
	return Excelhelper.getdata();

}

}
