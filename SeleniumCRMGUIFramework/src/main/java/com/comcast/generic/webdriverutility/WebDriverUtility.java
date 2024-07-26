package com.comcast.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility extends JavaUtility 
{
	public WebDriver openBrowser(String browser) 
	{
		WebDriver driver=null;
		switch(browser)
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
		default:
			driver=new ChromeDriver();
		 }
		return driver;
	}
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	public void waitForElementPresent(WebDriver driver , WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void switchToTabOnUrl(WebDriver driver ,String partialUrl) 
	{
		Set<String> childwindow = driver.getWindowHandles();
		for (String window : childwindow) 
		{
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(partialUrl)) 
				break;
		}
	}
	

	public void switchToTabOnTitle(WebDriver driver ,String partialTitle) 
	{
		Set<String> childwindow = driver.getWindowHandles();
		for (String window : childwindow) 
		{
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(partialTitle)) 
				break;
		}
	}
	
	
	public void switchToFrame(WebDriver driver , int index)	
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver , String nameID)	
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver , WebElement element )
	{
		driver.switchTo().frame(element);
	}
	public String switchToAlertAndGetText (WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}

	public void switchToAlertAndAccept (WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel (WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	public void select(WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mouseMoveOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void takeScreenShot(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		//Temporary Location
		File scrfile=ts.getScreenshotAs(OutputType.FILE);
		//Destination File
		File destfile=new File("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\AllScreenShots\\"+fileName+".png");
		//Copy from temporary location to targeted location
		FileHandler.copy(scrfile, destfile);
	}
	
	public void takeElementScreenShot(WebElement element, String fileName) throws IOException
	{
		//TakesScreenshot ts =(TakesScreenshot)driver;
		//Temporary Location
		File scrfile=element.getScreenshotAs(OutputType.FILE);
		//Destination File
		File destfile=new File("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\AllScreenShots\\"+fileName+".png");
		//Copy from temporary location to targeted location
		FileHandler.copy(scrfile, destfile);
	}
}
