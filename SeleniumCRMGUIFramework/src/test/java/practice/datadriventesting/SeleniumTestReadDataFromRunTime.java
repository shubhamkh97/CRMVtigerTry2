package practice.datadriventesting;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	
	public void seleniumtest() throws InterruptedException, IOException {
		
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
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
		default:
			System.out.println("Enter valid Browser Name");
		 }
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.close();
		
	}

}
