package Scenario1Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	Actions actions;
	
	@FindBy(id= "checkout")
	private WebElement Checkout;
	

	public Checkout(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	
	public void clickcheckout() {
		Checkout.click();
		
	}

}
