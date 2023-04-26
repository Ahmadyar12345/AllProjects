package Scenario5;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addproduct {
	
	Actions actions;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement Addfirst;
	
	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	private WebElement Addthird;
	
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removefirst;
	
	
	@FindBy(xpath= "///a[contains(@class,'shopping_cart_link')]")
	private WebElement clickCardIcon;
	
	
	
	public Addproduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		
	}
	
	
	public void addfirst() {
		Addfirst.click();
	}
	public void addthird() {
		Addthird.click();
	}
	public void removefirst() {
		removefirst.click();
	}
	public void clickcardicon() {
		clickCardIcon.click();
	}
}
