package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProvider.DataProviderClass;
import page_objects.HolidayPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.mainMasterPage;
import utilities.Log;

public class HolidayTest extends BaseClass {

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
		holidayPage = masterPage.validateHoliBtn();
		holidayPage = new HolidayPage();

		Thread.sleep(3000);

	}

	@Test(dataProvider = "HolidayProvider",dataProviderClass = DataProviderClass.class)
	public void HolidayCreationTest(String holi, String date) {
		Log.startTestCase(" Test for create Holiday");
		holidayPage.CreateFunc(holi, date);
		boolean result = holidayPage.foundIsDisplayed();
		Assert.assertTrue(result);
		Log.endTestCase(" Test for create Holiday");

	}

	@Test(dataProvider = "Holidaysearchdata",dataProviderClass = DataProviderClass.class)
	public void SearchFuncTest(String searchholi) {

		boolean result = holidayPage.search(searchholi);
		Assert.assertTrue(result);
	}

	@AfterMethod()

	public void tearDown() {
		getDriver().quit();
	}

}
