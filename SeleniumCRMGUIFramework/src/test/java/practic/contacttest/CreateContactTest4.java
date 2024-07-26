package practic.contacttest;

import java.io.FileInputStream;
//import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import java.io.FileNotFoundException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest4 {

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
			Row row = sh.getRow(1);
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
			
			
			//Step 2 : naviagte to Contact module
			
			driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
			// Step 3 : click on "Create Contact" Button
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			// Step 4 : Enter all the details and create new contact
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			driver.findElement(By.xpath("(//input[contains(@class,'crmbutton')])[2]")).click();
			
			
			// Step 5 : verify header msg Expected Result
			String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			if (actlastname.equals(lastname)) {
				System.out.println(lastname + " is created==PASS");
			}
			else {
				System.err.println(lastname + " is not created==FAIL");
			}
				
			//Step 6 : logout
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			driver.quit();
			
			
		
		
		
		
		
		
		
		
		
	}
}
