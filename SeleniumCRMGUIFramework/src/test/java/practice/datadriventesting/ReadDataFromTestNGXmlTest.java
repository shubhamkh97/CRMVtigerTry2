package practice.datadriventesting;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXmlTest {

	@Test
	public void sampleTest(XmlTest test) {
		String URL = test.getParameter("url");
		String BROWSER = test.getParameter("Browser");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		

	}

}
