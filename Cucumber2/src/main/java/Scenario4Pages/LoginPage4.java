package Scenario4Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage4 {
	Actions actions;
	
	@FindBy(id = "user-name")
	private WebElement UsernameTxtBox;
	
	@FindBy(id = "password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	public LoginPage4(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void enterUsername(String username) {
		UsernameTxtBox.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}
	public void clickloginBtn() {
		loginBtn.click();
	}
}
