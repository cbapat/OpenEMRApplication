package com.tieto.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

	
	
	
	public static Object[][] getSheetIntoObject(String fileDetail, String sheetName) throws IOException
	{
		FileInputStream file=new FileInputStream(fileDetail);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet(sheetName);
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
