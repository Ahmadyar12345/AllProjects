package Scenario4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout4 {
	Actions actions;
	
	@FindBy(id= "checkout")
	private WebElement Checkout;
	
	public Checkout4(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void clickcheckout() {
		Checkout.click();
		
	}

}
