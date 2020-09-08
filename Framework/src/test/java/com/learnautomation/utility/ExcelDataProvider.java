package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{

		File src=new File("./TestData/ARUNTESTDATA.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src); //converts into a raw data
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {System.out.println("unbale to read excel file"+e.getMessage());} 

	}
	public String  getStringData(int sheetIndex,int row,int coloumn)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();

	}

	public String  getStringData(String sheetName,int row,int coloumn)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue();

	}

	public double getNumericData(String sheetName,int row,int coloumn)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getNumericCellValue();
	}

}
