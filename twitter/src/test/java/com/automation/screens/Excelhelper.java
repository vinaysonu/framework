package com.automation.screens;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Excelhelper {
	
	@DataProvider
	public static String[][] getdata() throws Exception, NullPointerException  {
		String [][] data=null;
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("D:\\objectfiles\\employeedata.xlsx")));
		Sheet sheet = workbook.getSheet("sheet2");
		
		/*data=new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		data[0][0]=sheet.getRow(0).getCell(0).toString();
		data[0][1]=sheet.getRow(0).getCell(1).toString();
		data[0][2]=sheet.getRow(0).getCell(2).toString();
		data[0][3]=sheet.getRow(0).getCell(3).toString();
		*/
		
		data = new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		
		for (int rowindex=0;rowindex<sheet.getPhysicalNumberOfRows();rowindex++) {
			for(int colindex=0;colindex<sheet.getRow(rowindex).getPhysicalNumberOfCells();colindex++) {
				data[rowindex] [colindex]= sheet.getRow(rowindex).getCell(colindex).toString();
			}
			
		}
		workbook.close();
		return data;
		

	}

}
