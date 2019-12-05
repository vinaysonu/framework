package com.automation.testscripts.linear;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_CreateEmployee {
	
		
		WebDriver driver = null;
@BeforeTest
public void init() {
	
	WebDriverManager.chromedriver().setup();
		
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
}
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
@AfterTest
	public void destroy() {
		
	
	driver.quit();
	
	}
	
	@DataProvider
public String[][] getdata() throws Exception  {
		String [][] data=null;
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("D:\\objectfiles\\testdata.xlsx")));
		Sheet sheet = workbook.getSheet("sheet1");
		
		data=new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		data[0][0]=sheet.getRow(0).getCell(0).toString();
		data[0][1]=sheet.getRow(0).getCell(1).toString();
		data[0][2]=sheet.getRow(0).getCell(2).toString();
		data[0][3]=sheet.getRow(0).getCell(3).toString();
		return data;
		
	
}

	}

