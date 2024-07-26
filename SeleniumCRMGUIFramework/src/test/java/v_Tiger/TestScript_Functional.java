package v_Tiger;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestScript_Functional {

	//public static void main(String[] args) throws Throwable 
	@Test
	public void  testScript_Functional()
	{
		WebDriver driver=new ChromeDriver();
		
		  //Login 
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8888/");
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("password");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //Leads module		  
		  driver.findElement(By.xpath("//a[text()='Leads']")).click();
		  driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();	  
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		  
		  //Alert Handled with passion
		  Alert alrt=driver.switchTo().alert();
		  System.out.println("Warning!!! Mandatory Field "+alrt.getText());
		  alrt.accept();
		  
		  //Logout
		  Actions action=new Actions(driver);
		  action.moveToElement(driver.findElement(By.xpath("(//img)[4]"))).perform();
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  WebElement element= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		  action.moveToElement(element).click().perform();
		  
		  driver.quit();
		  
	}
}
