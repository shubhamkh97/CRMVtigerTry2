package v_Tiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript_System_2   {
	@Test
	public void  testScript_Functional() throws InterruptedException {

	//public static void main(String[] args) throws Throwable {
	 
	 WebDriver driver=new ChromeDriver();
		 
		//Login
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8888/");
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("password");
		  driver.findElement(By.id("submitButton")).click();
		  
		//Organization module
		  driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		//Create New Organization
		  driver.findElement(By.name("accountname")).sendKeys("Naruto");
		  driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		  
		//Search Organization by name
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		  driver.findElement(By.name("search_text")).sendKeys("Naruto");
		  Select dDown=new Select(driver.findElement(By.id("bas_searchfield")));
		  dDown.selectByVisibleText("Organization Name");
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
		//Contacts module
		  driver.findElement(By.linkText("Contacts")).click();	  
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  driver.findElement(By.name("lastname")).sendKeys("Uzumaki");
		  driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		  
		  String parentWindow=driver.getWindowHandle();
		  Set<String> childWindows=driver.getWindowHandles();
		  for(String window: childWindows)
		  {
			  driver.switchTo().window(window);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			 if(driver.getCurrentUrl().equals("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="))
			  {
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Naruto");
			  driver.findElement(By.name("search")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//a[@id='1']")).click();
			  }
		  }
		  driver.switchTo().window(parentWindow);
		  Actions action=new Actions(driver);
		  action.scrollByAmount(0,500);
		  Select selobj=new Select(driver.findElement(By.name("assigned_user_id")));
		  selobj.selectByVisibleText(" Administrator");
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		  
		//Search Contact by Organization name
		  driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();	
		  driver.findElement(By.name("search_text")).sendKeys("Naruto");
		  Select inDropDown1=new Select(driver.findElement(By.id("bas_searchfield")));
		  inDropDown1.selectByVisibleText("Organization Name");
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
		//Logout
		  action.moveToElement(driver.findElement(By.xpath("(//img)[4]"))).perform();
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  WebElement element= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		  action.moveToElement(element).click().perform();
		 
		  driver.quit();
		 
		            

	}

}
