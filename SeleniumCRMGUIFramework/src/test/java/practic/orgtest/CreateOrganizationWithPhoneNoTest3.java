package practic.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class CreateOrganizationWithPhoneNoTest3 {

	public static void main(String[] args) throws Exception {
		
		
		//Common Data
		FileInputStream fis = new FileInputStream("C:\\Users\\suvam\\Downloads\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		
		// Generate the random number
			Random ran = new  Random();
			int ranint = ran.nextInt(1000);
		
		// readtestscripts from excel
			FileInputStream fis1 = new FileInputStream("C:\\Users\\suvam\\Downloads\\GU_Automatication.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(7);
			String orgName = row.getCell(2).toString() + ranint;
			String phno = row.getCell(3).getStringCellValue();
			wb.close();
			
			WebDriver driver = null;
			
			if (Browser.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if (Browser.equals("edge")) {
				driver = new EdgeDriver();
			}
			else if (Browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			else {
				driver = new ChromeDriver();
			}
			
			
			//Step 1 : login to app
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			driver.manage().window().maximize();
			driver.get(Url);
			
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			
			
			//Step 2 : navigate to Organization module
			
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
			// Step 3 : click on "Create Organization" Button
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			// Step 4 : Enter all the details and create new organization
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phno);
			
			driver.findElement(By.xpath("(//input[contains(@class,'crmbutton')])[1]")).click();
			
			
			// Step 5 : verify header phno info Expected Result
			
			String actphno = driver.findElement(By.id("dtlview_Phone")).getText();
			if (actphno.equals(phno))
			{
				System.out.println(phno + " info is created==PASS");
			}
			else
			{
				System.out.println(phno + " info is not created==FAIL");
			}
		
			
			//Step 6 : logout
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			driver.quit();
			
			
		
		
		
		
		
		
		
		
		
	}
}
