package Scenario2Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	Actions actions;
	
	@FindBy(id = "user-name")
	private WebElement UsernameTxtBox;
	
	@FindBy(id = "password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//h3[contains(@data-test,'error')]")
	private WebElement verifyErrMsg;
	
	
	public LoginPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	public void enterUsername(String username) {
		UsernameTxtBox.sendKeys("locked_out_user");
	}
	public void enterPassword(String password) {
		passwordTxtBox.sendKeys("secret_sauce");
	}
	public void clickloginBtn() {
		loginBtn.click();
	}
	public String getErrMsg() {
		 String message = verifyErrMsg.getText();
		 return message;
		 }
}
