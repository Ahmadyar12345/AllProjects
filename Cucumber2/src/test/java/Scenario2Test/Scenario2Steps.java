package Scenario2Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Scenario2Pages.LoginPage2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2Steps {
	WebDriver driver;


	@Given("enter invalid user name and password")
	public void enter_invalid_user_name_and_password() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		// 2. Maximize it
		driver.manage().window().maximize();
		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");

	}

	@When("enter user name and password")
	public void enter_user_name_and_password() {

		LoginPage2 loginpage2 = new LoginPage2(driver);
		loginpage2.enterUsername("locked_out_user");
		loginpage2.enterPassword("secret_sauce");
		loginpage2.clickloginBtn();
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {

		LoginPage2 loginpage2 = new LoginPage2(driver);
		String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out";
		String actualErrMsg = loginpage2.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);

		driver.quit();

	}

}
