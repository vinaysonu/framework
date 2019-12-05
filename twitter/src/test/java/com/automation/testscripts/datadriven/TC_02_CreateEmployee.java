package com.automation.testscripts.datadriven;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.core.framework;
import com.automation.screens.Excelhelper;

public class TC_02_CreateEmployee extends framework {


@Test(dataProvider = "getdata")
public void createEmployee(String username,String password,String firstname,String lastname) throws Exception {


driver.get("https://opensource-demo.orangehrmlive.com/");

driver.findElement(By.name("txtUsername")).sendKeys(username);

driver.findElement(By.name("txtPassword")).sendKeys(password);

driver.findElement(By.name("Submit")).click();

driver.findElement(By.id("menu_pim_viewPimModule")).click();

driver.findElement(By.id("menu_pim_addEmployee")).click();

driver.findElement(By.name("firstName")).sendKeys(firstname);

driver.findElement(By.name("lastName")).sendKeys(lastname);

driver.findElement(By.id("btnSave")).click();

driver.findElement(By.id("welcome")).click();

driver.findElement(By.linkText("Logout")).click();
}	

@DataProvider
public String[][] getdata() throws Exception  {

	return Excelhelper.getdata();
	

}

}
