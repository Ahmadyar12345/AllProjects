package Scenario1Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import Com.bravenet.pages.LoginPage;
import Scenario1Pages.AddToCard1;
import Scenario1Pages.Checkout;
import Scenario1Pages.OverviewPayment;
import Scenario1Pages.YourInfo1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1Steps {
	WebDriver driver;

	@Given("user able to login the website")
	public void user_able_to_login_the_website() {
		
		 ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");

         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver(option);
		
		// 2. Maximize it
		driver.manage().window().maximize();
		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");

	}

	@When("enter username, password and postal code then click on continue button")
	public void enter_username_password_and_postal_code_then_click_on_continue_button() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername("standard_user");

		// enterpasspord
		loginpage.enterPassword("secret_sauce");

		// click login button
		loginpage.clickloginBtn();

	}

	@When("user able to add to card and click on card icon")
	public void user_able_to_add_to_card_and_click_on_card_icon() {

		// click click fist to add
		AddToCard1 addtocard1 = new AddToCard1(driver);
		addtocard1.clickfirst();
		// click second to add the card
		addtocard1.clicksecond();

		// click to card icon
		addtocard1.clickcardicon();

	}

	@When("user should checkout")
	public void user_should_checkout() {

		Checkout checkout = new Checkout(driver);
		checkout.clickcheckout();

	}

	@When("user should able to enter his information")
	public void user_should_able_to_enter_his_information() {
		YourInfo1 yourinfo1 = new YourInfo1(driver);
		yourinfo1.enterfirstname("Aman");
		yourinfo1.enterlastname("Ahmadyar");
		yourinfo1.enterpostalcode(20737);
		yourinfo1.clickcontinueBtn();

	}

	@Then("user should able to overview the payment")
	public void user_should_able_to_overview_the_payment() {

		OverviewPayment overviewpayment = new OverviewPayment(driver);
		overviewpayment.clickfinish();

		String expectedsuccessMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there";
		String actualsuccessMsg = overviewpayment.getsuccessMsg();
		Assert.assertEquals(actualsuccessMsg, expectedsuccessMsg);

		driver.quit();

	}

}
