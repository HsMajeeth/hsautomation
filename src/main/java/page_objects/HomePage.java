package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = ("//span[ text()='Main Master']"))
    private WebElement mster;
	
	
	
	Action_class action= new Action_class();

	public HomePage() {
		
		PageFactory.initElements(getDriver(),this );
		
		}
	
	public mainMasterPage mainMaster() {
		
		action.explicitWait(getDriver(), mster, 2);
		action.click(getDriver(), mster);
		
		return new mainMasterPage();
		
		
	}
	
	
	
	
	
	
	
	
	
}
