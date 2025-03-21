package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import page_objects.HomePage;
import page_objects.LoginPage;
import utilities.Log;
public class LoginTest extends BaseClass {



	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod()
	public void setup() {

		launchApp("firefox");
		launchApp("chrome");


	}
	@Test
	public void loginTest()   throws Throwable{
		Log.startTestCase("Login Test");
		loginPage=new LoginPage();
		loginPage.Email("majeeth.h@babujiventures.in");
		loginPage.Pass("Test@123");
		homePage =loginPage.SubBtn();
		Log.info("User Entered the credentials Succesfully");

		Thread.sleep(3000);
		String expectedUrl ="https://staging-mmsadmin.basispay.in/sidenav/dashboard";
		String actualUrl=loginPage.CurrentUrl();
		Log.endTestCase("Login Test");
		Assert.assertEquals(actualUrl, expectedUrl,"Login failed: URLs do not match.");
	}


	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

}
