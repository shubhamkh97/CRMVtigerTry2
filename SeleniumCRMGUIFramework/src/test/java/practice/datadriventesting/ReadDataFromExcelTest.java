package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step 1: Get the excel Path location & java object of the physical Excelfile
		FileInputStream fis=new FileInputStream("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\testScriptData.xlsx");
		
		//Step 2: Open WorkBook in Read Mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3: Get the control of "org" sheet
		Sheet sh=wb.getSheet("org");
		
		//Step 4: Get the control of "1st" Row
		Row row=sh.getRow(1);
		
		//Step 5: Get the control of "2nd" cell & read the String data
		Cell cell=row.getCell(2);
		System.out.println(cell.getStringCellValue());
		//Step 6: Close the Workbook
		/*wb.close();*/
		System.out.println(row.getCell(1).getStringCellValue());
		System.out.println(row.getCell(3).getNumericCellValue());
		System.out.println(sh.getRow(2).getCell(3).getNumericCellValue());
		//int k=wb.getSheet("org").getLastRowNum();
		//Doing it through method chaining
		System.out.println(wb.getSheet("org").getRow(2).getCell(1)/*.getStringCellValue()*/);
		/*
		 * System.out.println(k); String x="xyzabc"; if(x.equals("abc"))
		 * System.out.println(x+"*"); else if(x.contains("abc")) System.out.println(x);
		 */
		
		//wb.getSheet("org").getRow(1).createCell(4).setCellType(CellType.STRING);
		wb.getSheet("org").getRow(1).createCell(4).setCellValue("ok");
		
		FileOutputStream fos= new FileOutputStream("C:\\\\Users\\\\suvam\\\\OneDrive\\\\Desktop\\\\TekPyramid\\\\testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
