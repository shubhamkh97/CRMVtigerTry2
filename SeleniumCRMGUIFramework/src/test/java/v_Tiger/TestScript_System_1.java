package v_Tiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript_System_1 
{
	@Test
	public void  testScript_Functional()
	//public static void main(String[] args) throws Throwable 
	{
	   WebDriver driver=new ChromeDriver();
	   
	  //Login			  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
	  //Campaign module			  
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();	  
		driver.findElement(By.name("campaignname")).sendKeys("Facebook69");
		Select selobj=new Select(driver.findElement(By.name("assigned_user_id")));
		selobj.selectByVisibleText(" Administrator");
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys("2024-08-09");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					  
	  //Search Campaign by name
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[1]")).click();
		driver.findElement(By.name("search_text")).sendKeys("Facebook_1234");
		Select dDown=new Select(driver.findElement(By.id("bas_searchfield")));
		dDown.selectByVisibleText("Campaign Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	  //Leads module
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();	  
		driver.findElement(By.name("lastname")).sendKeys("moon");
		driver.findElement(By.name("company")).sendKeys("Facebook");
		Select selobj1=new Select(driver.findElement(By.name("assigned_user_id")));
		selobj1.selectByVisibleText(" Administrator");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 
	  //Search Lead by Company
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.name("search_text")).sendKeys("Facebook");
		Select inDropdown=new Select(driver.findElement(By.id("bas_searchfield")));
		inDropdown.selectByVisibleText("Company");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
 
	  //Logout
		action.moveToElement(driver.findElement(By.xpath("(//img)[4]"))).perform();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement element= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		action.moveToElement(element).click().perform();
		
	  driver.quit();
					 

	}

}
