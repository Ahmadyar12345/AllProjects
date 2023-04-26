package Scenario3Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Scenario3Pages.AddToCard3;
import Scenario3Pages.Checkout3;
import Scenario3Pages.LoginPage3;
import Scenario3Pages.YourInfo3;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3Steps {
	
	WebDriver driver;
	
	@Given("User should able to login the page")
	public void user_should_able_to_login_the_page() {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
		
		// 2. Maximize it
		driver.manage().window().maximize();
		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");
	   
	}
	
	@When ("Enter user name and password")
	public void Enter_user_name_and_password() {
		
		LoginPage3 loginpage3 = new LoginPage3(driver);
		loginpage3.enterUsername("problem_user");
		loginpage3.enterPassword("secret_sauce");
		loginpage3.clickloginBtn();
	}

	@When("User should able to add items to card")
	public void user_should_able_to_add_items_to_card() {
		
		AddToCard3 addtocard3 = new AddToCard3(driver);
		addtocard3.clickfirst();
		addtocard3.clickcardicon();
	   
	}

	@When("User should be able to checkout")
	public void user_should_be_able_to_checkout() {
		Checkout3 checkout3 = new Checkout3(driver);
		checkout3.clickcheckout3();
	 
	}

	@Then("User abel to enter his information and see the success message")
	public void user_abel_to_enter_his_information_and_see_the_success_message() {
		YourInfo3 yourinfo3 = new YourInfo3(driver);
		yourinfo3.enterfirstname("Aman");
		yourinfo3.enterlastname("Ahmadyar");
		yourinfo3.enterpostalcode(20737);
		yourinfo3.clickcontinue();
		
		//Verify Err message - 
		String expectedErrMsg = "Error: Last Name is required";
		String actualErrMsg =yourinfo3.GetErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		
		driver.quit();
	   
	}

}
