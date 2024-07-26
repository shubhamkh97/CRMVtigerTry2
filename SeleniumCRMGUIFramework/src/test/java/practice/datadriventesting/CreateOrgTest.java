package practice.datadriventesting;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
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
		 
		 /*switch(browserNo)
		 {
		 case 1:
			 WebDriver driver=new FirefoxDriver();
			 break;
		 case 2:
			 WebDriver driver=new ChromeDriver();
			 break;
		 case 3:
			 WebDriver driver=new EdgeDriver();
			 break;
		 case 4:
			 WebDriver driver=new SafariDriver();
			 break;
		default:
			System.out.println("Enter valid digit");*/
		 
			  
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
			/*
			 * case 4: driver=new SafariDriver(); break;
			 */
		default:
			System.out.println("Enter valid Browser Name");
		 }
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driver.close();
	}

}