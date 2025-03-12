package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import page_objects.LoginPage;

public class LoginTest extends BaseClass {
	
	
	
	LoginPage loginPage;
	
	@BeforeMethod()
	public void setup() {
	launchApp("chrome");
	
	}
	@Test
	public void loginTest()   throws Throwable{
		loginPage=new LoginPage();
		loginPage.Email("majeeth.h@babujiventures.in");
		loginPage.Pass("Test@123");
		loginPage.SubBtn();
		}

	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
}
