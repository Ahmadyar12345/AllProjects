package Scenario3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCard3 {
	Actions actions;

	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	private WebElement Addtocardfirst;
	
	
	@FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
			private WebElement clickCardIcon;
	

	public AddToCard3(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickfirst() {
		Addtocardfirst.click();
	}

 public void clickcardicon() {
	 clickCardIcon.click();

 }}
