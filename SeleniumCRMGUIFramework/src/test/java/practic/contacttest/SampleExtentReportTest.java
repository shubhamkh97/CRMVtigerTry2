package practic.contacttest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReportTest {
	ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		//Spark Report config
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TestScript Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add Environment Info and create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "CHROME-11");
	}
	
	@Test
	public void createContactTest() {
		ExtentTest test= report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate To Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDCF"))
			test.log(Status.PASS, "Contact Is Created");
		else
			test.log(Status.FAIL, "Contact  IS not Created");
	}
	@Test
	public void createContactWithPhoneNoTest() {
		ExtentTest test= report.createTest("createContactWithPhoneNoTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate To Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDFC"))
			test.log(Status.PASS, "Contact Is Created");
		else
			test.log(Status.FAIL, "Contact  IS not Created");
	}
		@AfterSuite
		public void configAS() {
			report.flush();
	}

}
