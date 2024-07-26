package practic.contacttest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MyntraPracticeTest {

	@Test
	public void getAllDescElements() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//a[normalize-space()='ONLINE SHOPPING']"))).perform();
		List<WebElement> elmnt = driver.findElements(By.xpath("//div[@class='desktop-genericInfo']"));
		for (WebElement webElement : elmnt) {
			String ele = webElement.getText();
			System.out.println(ele);
			
		}
	}
}
