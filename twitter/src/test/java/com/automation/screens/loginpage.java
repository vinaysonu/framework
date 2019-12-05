package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	@FindBy(id="txtUsername")
	private WebElement usernamefield= null;
	@FindBy(id="txtPassword")
	private WebElement passwordfield= null;
	@FindBy(id="btnLogin")
	private WebElement loginbtn= null;

public loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void login(String username,String password) {
	
	usernamefield.sendKeys(username);
	passwordfield.sendKeys(password);
	loginbtn.click();

}


}
