package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import action_driver.Action_class;
import baseClass.BaseClass;

public class ListenerClass extends Reporter implements ITestListener {

	Action_class action = new Action_class();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				// Ensure WebDriver is valid
				if (BaseClass.getDriver() != null) {
					// Capture screenshot
					String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());
					System.out.println("Screenshot captured for failed test: " + imgPath);

					// Log failure and attach screenshot to the Extent Report
					test.fail("Screenshot is attached",
							MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				} else {
					System.err.println("WebDriver instance is null. Unable to capture screenshot.");
				}
			} catch (Exception e) {
				System.err.println("Error while capturing screenshot or attaching to the report: " + e.getMessage());
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

}
