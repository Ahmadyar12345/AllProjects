package Scenario4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPayment4 {
	Actions actions;
	
	
	@FindBy(id= "finish")
	private WebElement finish;
	
	@FindBy(xpath= "//h2[contains(@class,'complete-header')]")
	private WebElement VerifySccMsg;
	
	public OverviewPayment4(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void clickfinish() {
		finish.click();
	}

	 public String GetsuccessMsg4() {
		 String message = VerifySccMsg.getText();
		 return message;
		 }
}
