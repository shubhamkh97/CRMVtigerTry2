package practic.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;*/
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustryTest {

	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream ("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\CommonData.properties");
		//Step 2:Use Properties class load all the keys 
		Properties pObj=new Properties();
		pObj.load(fis);
		//Step 3: Get the value based on key
		String BROWSER= pObj.getProperty("Browser");
		String URL= pObj.getProperty("url");
		String USERNAME= pObj.getProperty("username");
		String PASSWORD= pObj.getProperty("password");
		 WebDriver driver=null;
			switch(BROWSER)
			 {
			 case "Chrome":
				 driver=new ChromeDriver();
				 break;
			 case "Firefox":
				 driver=new FirefoxDriver();
				 break;
			 case "Edge":
				 driver=new EdgeDriver();
				 break;
			default:
				System.out.println("Enter valid Browser Name");
			 }
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Random random=new Random();
			int randomnum=random.nextInt(1000);
			FileInputStream fisx=new FileInputStream("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\testScriptData.xlsx");
			//Step 2: Open WorkBook in Read Mode
			Workbook wb=WorkbookFactory.create(fisx);
			String orgName=wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+randomnum;
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			Select IndDrop= new Select(driver.findElement(By.name("industry")));
			String industry=wb.getSheet("org").getRow(1).getCell(3).getStringCellValue();
			IndDrop.selectByValue(industry);
			
			Select TypeDrop= new Select(driver.findElement(By.name("accounttype")));
			String type=wb.getSheet("org").getRow(1).getCell(4).getStringCellValue();
			TypeDrop.selectByValue(type);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			
			//Verify Expected Result
			String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			String OrgNamVerify=driver.findElement(By.id("dtlview_Organization Name")).getText();
			String IndVerify=driver.findElement(By.id("dtlview_Industry")).getText();
			String TypeVerify=driver.findElement(By.id("dtlview_Type")).getText();
			
			if (headerInfo.contains(orgName)&&OrgNamVerify.equals(orgName)&&IndVerify.equals(industry)&&TypeVerify.equals(type)) 
				System.out.println(orgName+" is Created /n TestCase ======= PASS");
			
			else 
				System.out.println(orgName+" is Not Created /n TestCase ======= FAIL");
				
			
			
			driver.quit();
			

	}

}
