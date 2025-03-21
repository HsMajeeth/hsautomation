package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import page_objects.HolidayPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.mainMasterPage;
import utilities.Log;

public class Mainmaster_hoidayTest extends BaseClass{
	
	LoginPage loginPage;
	
	 HomePage homePage;
	 
	 mainMasterPage masterPage;
	 
	 HolidayPage holidayPage;
	 
	 @BeforeMethod()
		public void setup() throws InterruptedException {
		launchApp("chrome");
		loginPage = new LoginPage();
        loginPage.Email("majeeth.h@babujiventures.in");
        loginPage.Pass("Test@123");
        homePage = loginPage.SubBtn();

        // Wait for HomePage to load
        Thread.sleep(3000);
  
        // Navigate to Main Master Page
        masterPage = homePage.mainMaster();
        holidayPage=masterPage.validateHoliBtn();
        Thread.sleep(3000);
       
        
       
		}
	 @AfterMethod()
		public void tearDown() {
			getDriver().quit();
		}
	 @Test(retryAnalyzer = utilities.Retry.class)
	 public void validateTheHoliBtnTest() throws InterruptedException {
		Log.startTestCase("To check the Holiday button navigation");
		String CurrentUrl= holidayPage.currenturl();
		String ExpectedUrl="https://staging-mmsadmin.basispay.in/sidenav/governmentholidy";
		Thread.sleep(3000);
		Assert.assertEquals(CurrentUrl, ExpectedUrl,"Navigation to Main Master Page failed: URLs do not match. ");
		Log.endTestCase("To check the Holiday button navigation");
		 
	 }
	

}
