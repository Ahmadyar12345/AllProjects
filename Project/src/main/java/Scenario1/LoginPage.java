package Scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	Actions actions;

	@FindBy(id = "user-name")
	private WebElement UsernameTxtBox;

	@FindBy(id = "password")
	private WebElement passwordTxtBox;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
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
	}}
