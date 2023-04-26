package Scenario1Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPayment {
	
	Actions actions;
	
	@FindBy(id= "finish")
	private WebElement finish;
	
	@FindBy(xpath= "//div[contains(@class,'complete-text')]")
	private WebElement verifysuccessMsg;

	public OverviewPayment(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	public void clickfinish() {
		finish.click();
	}
	
	 public String getsuccessMsg() {
		 String message = verifysuccessMsg.getText();
		 return message;
		 }

}
