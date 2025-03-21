package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProvider.DataProviderClass;
import page_objects.EmailConfiguartionPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.mainMasterPage;

public class EmailConfigurationTest extends BaseClass {

	LoginPage loginPage;

	HomePage homePage;

	mainMasterPage masterPage;
	
	EmailConfiguartionPage emailconfigpage;

	@BeforeMethod()

	public void setup() throws InterruptedException {
	Thread.sleep(5000);
	launchApp("chrome");
	loginPage = new LoginPage();
	loginPage.Email("majeeth.h@babujiventures.in");
	loginPage.Pass("Test@123");
	homePage = loginPage.SubBtn();

	// Wait for HomePage to load
	Thread.sleep(3000);

	// Navigate to Main Master Page
	masterPage = homePage.mainMaster();
	
   emailconfigpage =masterPage.valiEmailconfBtn();
   
	Thread.sleep(3000);

    }
	@Test(dataProvider = "Emaildata",dataProviderClass = DataProviderClass.class)
	public void emailcreationTest(String email) {
		
		emailconfigpage.createEmailconfig(email);
		boolean result = emailconfigpage.emailValidate("prakash.p@babujiventures.in");
		Assert.assertTrue(result);
	}
	@AfterMethod()

	public void tearDown() {
		getDriver().quit();
	}

}
