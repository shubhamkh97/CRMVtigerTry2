package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	String fileLocation;
	public ExcelUtility(String fileLocation)
{
	this.fileLocation=fileLocation;
}

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis=new FileInputStream(fileLocation);
		
		Workbook wb=WorkbookFactory.create(fis);
		
		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	public String getNumDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis=new FileInputStream(fileLocation);
		
		Workbook wb=WorkbookFactory.create(fis);
		
		String data= ""+(long)wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{	
		FileInputStream fis=new FileInputStream(fileLocation);
		
		Workbook wb=WorkbookFactory.create(fis);
		int data=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return data;
		
	}
	public int getCellCount(String sheetName,int rowNum) throws EncryptedDocumentException, IOException
	{	
		FileInputStream fis=new FileInputStream(fileLocation);
		
		Workbook wb=WorkbookFactory.create(fis);
		int data=wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		wb.close();
		return data;
		
	}
	public String setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis=new FileInputStream(fileLocation);
		
		Workbook wb=WorkbookFactory.create(fis);

		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(fileLocation);
		wb.write(fos);
		String check= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		if (check==data)
		{
			wb.close();
			return check+" is successfully inserted";
		}
		else
		{
			wb.close();
			return check+" is not successfully inserted";
		}
			
	
	}
}
