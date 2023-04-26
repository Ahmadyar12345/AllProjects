package Scenario5Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Finish5 {
	Actions actions;

	@FindBy(id = "finish")
	private WebElement finishButton;

	@FindBy(xpath = "//h2[contains(@class,'complete-header')]")
	private WebElement VerifySccMsg;

	public Finish5(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void clickfinish() {
		finishButton.click();
	}

	public String getsuccessMsg5() {
		String message = VerifySccMsg.getText();
		return message;
	}

}
