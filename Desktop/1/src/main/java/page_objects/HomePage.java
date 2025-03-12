package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = ("//div[contains(text(),' Main Master')]"))
    private WebElement mster;
	
	@FindBy(xpath = "//a[contains(text(),'Government Holiday')]")
	private WebElement holi;  
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(),this );
		
		}
	
	
	
	
	
}
