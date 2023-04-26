package Scenario5Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContinueBtn {

	Actions actions;
	
	@FindBy(xpath="//span[contains(@class,'title')]")
	private WebElement yourcard;

	@FindBy(id= "continue-shopping")
	private WebElement continueShopping;
	
	public ContinueBtn(WebDriver driver)  {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		
	}
	
	public void displayed() {
		yourcard.isDisplayed();
	}
	
	//public void clickcontiueshopping() {
	
	//continueShopping.click();
	
	
}

