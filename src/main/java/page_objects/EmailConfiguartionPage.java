package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class EmailConfiguartionPage extends BaseClass {
	
	
	Action_class action=new Action_class();
	@FindBy(xpath = "//span[text()='Create Email']")
	private WebElement createBtn;
	@FindBy(xpath = "//input[@name=\"emails\"]")
	private WebElement enterEmail;
	@FindBy(className ="kycsubmitbtn" )
	private WebElement kycsubBtn; 
	@FindBy(className ="kycclosebtn" )
	private WebElement kycclosebtn; 
	@FindBy(name="search" )
	private WebElement kycsearchbtn; 
	@FindBy(xpath="//*[@id=\"excel-table\"]/tbody/tr[1]/td[2]")
	private WebElement kycsearch;
	@FindBy(xpath = "//select[@id='itemsPerPage']")
	private WebElement selectPage;
	
	@FindBy(xpath = "//td[@class=\"tabledata\" and text()=' 15 ']")
	private WebElement found15;
	
	
	public EmailConfiguartionPage(){
		
		
		PageFactory.initElements(getDriver(),this );
	}
	
	public void createEmailconfig(String email) {
		
		action.click(getDriver(), createBtn);
		action.SendKeys(enterEmail, email);
		action.click(getDriver(), kycsubBtn);
	}
	
	public boolean emailValidate(String emailData)
	{
		return action.isDisplayed(getDriver(), kycsearch);
		
	}
	public boolean searchData(String search) {
        action.SendKeys(kycsearchbtn, search);
        return action.isDisplayed(getDriver(), kycsearch);
       
	}
	
	public String pageSelect() {
		action.selectByVisibleText("15", selectPage);
		return action.getText(selectPage);
	}
	
}

