package com.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.framework;
import com.automation.screens.Excelhelper;


public class keyworddriven extends framework {
	

@Test(dataProvider = "getdata")
public void createEmployee(String testname,String stepdescription,String action,String properties, String data) throws Exception {
actionsHelper(action, properties , data);

}

public void actionsHelper(String action,String properties, String data )throws Exception, NullPointerException {
	
	WebElement element = null;
	Actions actions = null;
	if(properties!= null) {
		element=findElement(properties);
	}

	switch (action) {
	case "enterUrl":
		driver.get(data);
		break;
	case "setText":
		element.sendKeys(data);
		break;
	case "click":
		element.click();
		break;
	case "doubleclick":
		actions=new Actions(driver);
		actions.doubleClick(element).perform();
		break;
	case "rightclick":
		actions=new Actions(driver);
		actions.contextClick(element).perform();
		break;
	case "moveToElement":
		actions=new Actions(driver);
		actions.moveToElement(element).perform();
		break;
	case "delay":
		Thread.sleep(2000);
	}
}

public WebElement findElement(String properties) {
	WebElement webElement = null;
	String locatorType= properties.split("=")[0];
	String locatorvalue= properties.split("=")[1];
	switch (locatorType) {
	case "id":
		webElement= driver.findElement(By.id(locatorvalue));
		break;
	case "name":
		webElement= driver.findElement(By.name(locatorvalue));
		break;
	case "className":
		webElement= driver.findElement(By.className(locatorvalue));
		break;
	case "linkText":
		webElement= driver.findElement(By.linkText(locatorvalue));
		break;
	}
	
	return webElement;
	
}



@DataProvider
public String[][] getdata() throws Exception  {
	
	return Excelhelper.getdata();
}
}
