package Scenario5;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortHighToLow {
	
	Actions actions;
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement NameAToZ;
	
	@FindBy(xpath = "//option[contains(@value,'hilo')]")
	private WebElement PricehighTolow;
	
	@FindBy(id= "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement Add1Tocard;
	
	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	private WebElement Add2card;
	
	@FindBy(xpath= "//span[contains(@class,'shopping_cart_badge')]")
	private WebElement twoitems;
	
	@FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
	private WebElement clickcardicon;
	
	public SortHighToLow(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	public void NameAToZ() {
		NameAToZ.click();
	}
		public void Pricehightolow() {
			PricehighTolow.click();
		}
		 public void firstitem() {
			 Add1Tocard.click();}
		 public void seconditem() {
			 Add2card.click(); }
		 public void veriyitems() {
			 twoitems.click();}
		 public void clickcardicon() {
			 clickcardicon.click();
		 }}

