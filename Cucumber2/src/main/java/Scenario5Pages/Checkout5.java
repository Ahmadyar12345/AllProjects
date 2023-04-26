package Scenario5Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout5 {
	Actions actions;
	
	@FindBy(id= "checkout")
	private WebElement Checkout;
	
	@FindBy(xpath = "//span[contains(@class,'Title')]")
	private WebElement Verifytext;
	
	public Checkout5(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	public void verifytext() {
		Verifytext.sendKeys("displayed");
	}
	
	public void clickcheckout() {
		Checkout.click();
		
	}

}
