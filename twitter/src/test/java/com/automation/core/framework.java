package com.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framework {
	protected WebDriver driver =null;
	
	@BeforeTest
	public void init() {

	WebDriverManager.chromedriver().setup();
		
	driver = new ChromeDriver();

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
}

	@AfterTest
	public void destroy() {
		

	driver.quit();

	}
}