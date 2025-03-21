package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	

	    // Start Report
	    public static void StartReport() {
	        // Set the output path for the report
	        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport/" + "MyReport.html";

	        // Initialize ExtentSparkReporter
	        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

	        // Configure the reporter (add theme, title, encoding, etc.)
	        reporter.config().setDocumentTitle("Automation Test Report"); // Title of the report
	        reporter.config().setReportName("Merchant Panel Test Results"); // Name of the report
	        reporter.config().setTheme(Theme.DARK); // Set the theme: DARK or STANDARD
	        reporter.config().setEncoding("UTF-8"); // Character encoding for Tamil or other regional languages
	        reporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss"); // Custom timestamp format

	        // Initialize ExtentReports and attach the reporter
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);

	        // Add system or environment details to the report
	        extent.setSystemInfo("Author", "Majeeth");
	        extent.setSystemInfo("Category", "End to End Testing");
	        extent.setSystemInfo("Host", "BVpl");
	        extent.setSystemInfo("Operating System", "Windows 10");
	        extent.setSystemInfo("Browser", "Chrome");

	        // Create an initial test entry
	        test = extent.createTest("Merchant Panel Testing");
	        test.assignCategory("End to End Tests");
	        test.assignAuthor("Majeeth");
	   
	}
	public static void flushReport() {
		
		extent.flush();
	}
}
