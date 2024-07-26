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
import org.openqa.selenium.WebElement;
//import java.io.FileNotFoundException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest2 {

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
			Row row = sh.getRow(4);
			String orgName = row.getCell(2).toString() + ranint;
			String industry = row.getCell(3).toString();
			String type = row.getCell(4).toString();
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
			
			
			//Step 2 : naviagte to Organization module
			
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
			// Step 3 : click on "Create Organization" Button
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			// Step 4 : Enter all the details and create new organization
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			
			//selecting the industry dropdown
			WebElement webel = driver.findElement(By.xpath("//select[@name='industry']"));
			Select sel = new Select(webel);
			sel.selectByVisibleText(industry);
			
			//selecting the type
			WebElement webel1 = driver.findElement(By.name("accounttype"));
			Select sel1 = new Select(webel1);
			sel1.selectByVisibleText(type);
			
			driver.findElement(By.xpath("(//input[contains(@class,'crmbutton')])[1]")).click();
			
			
			// Step 5 : verify the industry and type info
			
			String actindu =driver.findElement(By.id("dtlview_Industry")).getText();
			if (actindu.equals(industry)) {
				System.out.println(industry + " info is verified==PASS");
			}
			else {
				System.out.println(industry + " info is not verified==FAIL");
			}
			
			String acttype = driver.findElement(By.id("dtlview_Type")).getText();
			if (acttype.equals(type)) {
				System.out.println(type + " info is verified==PASS");
			}
			else {
				System.out.println(type + " info is not verified==FAIL");
			}
			
			
			//Step 6 : logout
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			driver.quit();
			
			
		
		
		
		
		
		
		
		
		
	}
}
