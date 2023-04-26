package Scenario4Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortLowToHigh {

	Actions actions;
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement NameAToZ;

	//@FindBy(linkText = "Price (low to high)")
	@FindBy(xpath= "//option[contains(@value,'lohi')]")
	private WebElement PricelowTohigh;
	
	@FindBy(id= "add-to-cart-sauce-labs-onesie")
	private WebElement AddTocard;
	
	@FindBy(xpath= "//a[contains(@class,'shopping_cart_link')]")
	private WebElement clickiconcard;
	
	
	public SortLowToHigh(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void NameAToZ() {
		NameAToZ.click();
	}
		public void PricelowTohigh() {
			PricelowTohigh.click();
		}
		 public void AddTocard() {
			 AddTocard.click();
		 }
		 public void clickiconcard() {
			 clickiconcard.click();
		 }}

