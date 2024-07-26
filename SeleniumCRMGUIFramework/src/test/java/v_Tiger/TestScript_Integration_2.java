package v_Tiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript_Integration_2 {
	@Test
	public void  testScript_Functional() {

	//public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		
		//Login
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8888/");
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("password");
		  driver.findElement(By.id("submitButton")).click();
		  
		//Vendors module
		  Actions action=new Actions(driver);
		  action.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		  driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		  driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		  driver.findElement(By.name("vendorname")).sendKeys("Chocolate");
		  driver.findElement(By.id("phone")).sendKeys("+919040127075");
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 
		//Search vendor by phone number
		 driver.findElement(By.xpath("(//a[text()='Vendors'])[1]")).click();
		 driver.findElement(By.name("search_text")).sendKeys("+919040127075");
		 Select dDown=new Select(driver.findElement(By.id("bas_searchfield")));
		 dDown.selectByVisibleText("Phone");
		 driver.findElement(By.xpath("//input[@name='submit']")).click();
		 
		//Logout
		 action.moveToElement(driver.findElement(By.xpath("(//img)[4]"))).perform();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 WebElement element= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		 action.moveToElement(element).click().perform();
		  
		 driver.quit();
		
	}

}
