package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoTest {
	
	@Test
	public void readProperties() throws IOException
	{
		FileInputStream file= new FileInputStream("testdata/data.properties");
		
		Properties prop=new Properties();
		
		prop.load(file);
		
		
	}
	
	/*@DataProvider
	public Object[][] fillData()
	{
		Object[][] data= new Object[2][4];
		
		data[0][0]="John";
		data[0][1]="John123";
		data[0][2]="Armenian";
		data[0][3]="Invalid username or password";
		
		data[1][0]="Paul";
		data[1][1]="Paul123";
		data[1][2]="Dutch";
		data[1][3]="Invalid username or password";
		
		return data;
		
	}
	
	//@Test (dataProvider="fillData")
	public void fillForm(String un, String pass, String sDropdown, String sError)
	{
		System.out.println(un+" "+pass+" "+sDropdown+" "+sError);
	}*/
	
	//@Test
	@DataProvider
	public Object[][] readExcel() throws IOException
	{
		FileInputStream file=new FileInputStream("testdata/OpenEMRData.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet("validCredentialsTestData");
	    int rowCount= sheet.getPhysicalNumberOfRows();
	    int cellCount= sheet.getRow(0).getPhysicalNumberOfCells();
	   	   
	   XSSFRow row;
	   XSSFCell cell;
	   
	   System.out.println(rowCount);
	   System.out.println(cellCount);
	   
	   Object[][] main = new Object[rowCount-1][cellCount];
	   
	   DataFormatter format= new DataFormatter();
		
		for (int r=1;r<rowCount;r++)
		{
			 row=sheet.getRow(r);
			 for (int c=0; c<cellCount; c++)
			 {
					 cell= row.getCell(c);
			 		 String str= format.formatCellValue(cell);
					 System.out.println(str);
					 if (r!=0)
					 {
					 main[r-1][c]=str;
					 }
			 }
		}
		//.//.System.out.println(str);
		
		book.close();
		
		file.close();
		return main;
		
		
	}
	
	
	
	

}
