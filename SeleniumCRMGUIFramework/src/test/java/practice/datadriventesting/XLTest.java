package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step 1: Get the excel Path location & java object of the physical Excelfile
		FileInputStream fis=new FileInputStream("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\testScriptData.xlsx");
		
		//Step 2: Open WorkBook in Read Mode
		Workbook wb=WorkbookFactory.create(fis); 
		for(int k=0; k<=wb.getSheet("Sheet1").getLastRowNum();k++)
		{
			for(int j=0; j<wb.getSheet("Sheet1").getRow(k).getLastCellNum();j++)
				System.out.print(wb.getSheet("Sheet1").getRow(k).getCell(j)+" ");
			System.out.println();
		}
		

	}

}
