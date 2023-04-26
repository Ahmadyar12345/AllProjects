package Scenario1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class YourInfo1 {
	Actions actions;
	
	@FindBy(id = "first-name")
	private WebElement firstnameTxtBox;
	
	@FindBy (id= "last-name")
	private WebElement lastnameTxtBox;
	
	@FindBy (id = "postal-code")
	private WebElement postalcodeTxtBox;
	
	@FindBy(id= "continue")
	private WebElement clickcontinue;
	
	public YourInfo1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void enterfirstname(String string) {
		firstnameTxtBox.sendKeys("Aman");
		}
	
	public void enterlastname(String string) {
		lastnameTxtBox.sendKeys("Ahmadyar");
		}
	
	public void enterpostalcode(int i) {
		postalcodeTxtBox.sendKeys("20737");
	}
	
	public void clickcontinueBtn() {
		clickcontinue.click();
	}
	}
