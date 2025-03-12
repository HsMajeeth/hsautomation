package baseClass;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//public static Properties prop;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	public WebDriver getDriver() {

		return driver.get();		

	}
//	@BeforeSuite()
//
//	public void loadConfig() throws IOException {
//
//
//		prop = new Properties();
//		FileInputStream ip = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\1\\Configuration\\config.properties");
//		prop.load(ip);
//	}
//

    public  void launchApp(String browserName) {

    	if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}

	
    getDriver().manage().window().maximize();
	//Delete all the cookies
	getDriver().manage().deleteAllCookies();
	//Implicit TimeOuts
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	
	//PageLoad TimeOuts
	getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(2000));
	
	//Launching the URL
	getDriver().get("https:staging-mmsadmin.basispay.in/login");


}
}
