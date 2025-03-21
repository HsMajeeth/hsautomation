package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class HolidayPage extends BaseClass {

	Action_class action= new Action_class();
	
	
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement createBtn;
	
	@FindBy(xpath="//input[@name='hildaysnames']")
	private WebElement hoilname;
	@FindBy(xpath="//input[@name=\"actype\"]")
	private WebElement dateofHoi;
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div/form/div[3]/button[1]")
	private WebElement subBtn;
	@FindBy(xpath="//td[text()=' sunday ']")
	private WebElement txt;


	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement serchFunc;
	@FindBy(xpath="//td[text()='12-12-2025']")
	private WebElement 	date;
	

	 

	public HolidayPage() {

		PageFactory.initElements(getDriver(),this );

	}
	public String currenturl() {
		return action.getCurrentURL(getDriver());
	}
	

	public void CreateFunc(String holidayName,String date) {
		action.implicitWait(getDriver(), 5);
		action.click(getDriver(), createBtn);
		action.SendKeys(hoilname, holidayName);
		action.SendKeys(dateofHoi, date);}

	public void CreateFunc() {
		action.implicitWait(getDriver(), 5);
		action.click(getDriver(), createBtn);
		action.SendKeys(hoilname, "sunday");
		action.SendKeys(dateofHoi, "12.12.2025");

		action.click(getDriver(), subBtn);
	}
	public boolean foundIsDisplayed() {
		
		return action.isDisplayed(getDriver(), txt);
	}

	public boolean search(String searchholi) {
		action.SendKeys(serchFunc, searchholi);
		return action.isDisplayed(getDriver(), date);
	}

	
	
}
