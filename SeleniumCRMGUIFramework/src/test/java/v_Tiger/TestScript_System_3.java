package v_Tiger;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript_System_3 {
	@Test
	public void  testScript_Functional() throws InterruptedException

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
		
	  //Organization module
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	  //Create new organization
		Random random=new Random();
		int randomnum=random.nextInt(1000);
		String ogNm="Ryan"+ randomnum;
		  
		driver.findElement(By.name("accountname")).sendKeys(ogNm);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		Thread.sleep(2000);
		
	  //Search Organization by name
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(ogNm);
		Select dDown=new Select(driver.findElement(By.id("bas_searchfield")));
		dDown.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	  //Contacts module
		driver.findElement(By.linkText("Contacts")).click();	  
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("moon");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		String parentWindow=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		for(String window: childWindows)
		  {
		  driver.switchTo().window(window);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		  if(driver.getCurrentUrl().equals("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="))
		  	{
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ogNm);
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
		driver.findElement(By.name("search_text")).sendKeys(ogNm);
		Select inDropDown1=new Select(driver.findElement(By.id("bas_searchfield")));
		inDropDown1.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	  //Opportunity module
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("maven");
		Select relatedTo=new Select(driver.findElement(By.id("related_to_type")));
		relatedTo.selectByValue("Accounts");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String parentWindow1=driver.getWindowHandle();
		
		Set<String> childWindows1=driver.getWindowHandles();
		for(String window: childWindows1)
			{
			 driver.switchTo().window(window);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			 if(driver.getCurrentUrl().equals("http://localhost:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord="))
			  {
				 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ogNm);
				 driver.findElement(By.name("search")).click();
				 driver.findElement(By.xpath("//a[@id='1']")).click();
			  }
			}
		driver.switchTo().window(parentWindow1);
		Select selobj2=new Select(driver.findElement(By.name("assigned_user_id")));
		selobj2.selectByVisibleText(" Administrator");
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys("2024-07-31");
		Select salesstage=new Select(driver.findElement(By.xpath("//select[@name='sales_stage']")));
		salesstage.selectByIndex(4);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
	  //Logout
		action.moveToElement(driver.findElement(By.xpath("(//img)[4]"))).perform();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement element= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		action.moveToElement(element).click().perform();
		
	   driver.quit();
					 

	}

}
