package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.mysql.jdbc.Driver;

public class VerificationFromHRMDB {

	@Test
	public void sampleTest(XmlTest test) throws SQLException, InterruptedException {
		String URL = test.getParameter("URL");
		String BROWSER = test.getParameter("Browser");
		String USERNAME = test.getParameter("UserName");
		String PASSWORD = test.getParameter("Password");
		
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
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
			/*
			 * case 4: driver=new SafariDriver(); break;
			 */
		default:
			System.out.println("Enter valid Browser Name");
		 }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		Random random=new Random();
		int randomnum=random.nextInt(1000);
		String PROJECT=test.getParameter("Project");
		String RanProNam=PROJECT+randomnum;
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(RanProNam);
		
		
		Thread.sleep(2000);
		driver.close();
		
		
		//Step 1: load/ register the database driver
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			
		//Step 2: connect to database
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
			System.out.println("done connection");
		
		//Step 3: Create SQL statement
			Statement stat=conn.createStatement();
		//Step 4: Execute Select query and get Result
			ResultSet resset=stat.executeQuery("select * from employees");
			while(resset.next())
			{
				System.out.println(resset.getString(1)+"  "+resset.getString(2)+"  "+resset.getString(3)+"  "+resset.getString(4));
			}
		//Step 5: Close the connection
			conn.close();
		
	}

}
