package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addemployees_screen {

	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement pimbtn=null;
	
	@FindBy(id = "menu_pim_addEmployee")
	private WebElement addemployeebtn=null;
	
	@FindBy(id = "firstName")
	private WebElement firstnametxt=null;
	
	@FindBy(id = "lastName")
	private WebElement lastnametxt=null;
	
	@FindBy(id = "btnSave")
	private WebElement savebtn=null;

	@FindBy(id = "welcome")
	private WebElement welcomebtn=null;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutbtn=null;
	
	public addemployees_screen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addemployee(String firstname,String lastname) {
		pimbtn.click();
		addemployeebtn.click();
		firstnametxt.sendKeys(firstname);
		lastnametxt.sendKeys(lastname);
		savebtn.click();
		welcomebtn.click();
		logoutbtn.click();
		
		
	}
	
	
}
