package Scenario1Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCard1 {
	Actions actions;

	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	private WebElement Addtocardfirst;
	
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement Addtocardsecond;
	
	
	@FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
			private WebElement clickCardIcon;
	
	public AddToCard1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickfirst() {
		Addtocardfirst.click();
	}
	public void clicksecond() {
		Addtocardsecond.click();
	}
	 
 public void clickcardicon() {
	 clickCardIcon.click();

 }}
