package practic.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
//import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest5 {

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
			Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(4);
			String lastname = row.getCell(2).toString() + ranint;
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
			
			driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
			// Step 3 : click on "Create Organization" Button
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			// Step 4 : Enter all the details and create new organization
			
			
			Date dateobj = new Date();
			
			//System.out.println(dateobj.toString());
			
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String startdate  = sim.format(dateobj);
			

			
			Calendar cal =sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,30);
			String enddate = sim.format(cal.getTime());
			
			
			
			
			
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			driver.findElement(By.id("jscal_field_support_start_date")).clear();
			driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(startdate);
			//System.out.println(startdate);
			
			driver.findElement(By.id("jscal_field_support_end_date")).clear();
			driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(enddate);
			//System.out.println(enddate);
			
			driver.findElement(By.xpath("(//input[contains(@class,'crmbutton')])[2]")).click();
			
			
			// Step 5 : verify header msg Expected Result
			String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			if (actlastname.equals(lastname)) {
				System.out.println(lastname + " is verified==PASS");
			}
			else {
				System.out.println(lastname + " is not verified==FAIL");
			}
				
			//verify the date
			String actdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
			if (actdate.equals(startdate)) {
				System.out.println(startdate + "  current date is displayed==PASS");
			}
			else {
				System.out.println(startdate + " current date is not displayed==FAIL");
			}
			
			
			String rtenddt = driver.findElement(By.id("dtlview_Support End Date")).getText();
			if (rtenddt.equals(enddate)) {
				System.out.println(enddate + "  end date is displayed==PASS");
			}
			else {
				System.out.println(enddate + " end date is not displayed==FAIL");
			}
			
			
			//Step 6 : logout
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			driver.quit();
			
			
		
		
		
		
		
		
		
		
		
	}
}
