package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
	@Test
	public void runtimeParameterTest() {
		
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println("Test Environment is "+System.getProperty("url")+URL);
		System.out.println("Browser is "+System.getProperty("browser")+BROWSER);
		System.out.println("User name is "+System.getProperty("username")+USERNAME);
		System.out.println("Password is "+System.getProperty("password")+PASSWORD);
		
	}

}
