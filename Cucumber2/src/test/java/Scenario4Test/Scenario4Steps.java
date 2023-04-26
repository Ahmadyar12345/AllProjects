package Scenario4Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Scenario4Pages.Checkout4;
import Scenario4Pages.LoginPage4;
import Scenario4Pages.OverviewPayment4;
import Scenario4Pages.SortLowToHigh;
import Scenario4Pages.YourInfo4;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4Steps {
	WebDriver driver;

	@Given("open the website and check the items")
	public void open_the_website_and_check_the_items() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		// 2. Maximize it
		driver.manage().window().maximize();
		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");

	}

	@When("able to login the sign in page")
	public void able_to_login_the_sign_in_page() {

		LoginPage4 loginpage4 = new LoginPage4(driver);
		loginpage4.enterUsername("standard_user");
		loginpage4.enterPassword("secret_sauce");
		loginpage4.clickloginBtn();

	}

	@When("able to sort from low to high the items")
	public void able_to_sort_from_low_to_high_the_items() {
		SortLowToHigh sortlowtohigh = new SortLowToHigh(driver);
		sortlowtohigh.NameAToZ();
		sortlowtohigh.PricelowTohigh();
		sortlowtohigh.AddTocard();
		sortlowtohigh.clickiconcard();

	}

	@When("able to checkout the items")
	public void able_to_checkout_the_items() {
		Checkout4 checkout4 = new Checkout4(driver);
		checkout4.clickcheckout();

	}

	@Then("Enter you information ")
	public void enter_you_information() {
		YourInfo4 yourinfo = new YourInfo4(driver);
		yourinfo.enterfirstname("Aman");
		yourinfo.enterlastname("Ahmadyar");
		yourinfo.enterpostalcode(20737);
		yourinfo.clickcontinue();

	}

	@When("User should able to check the payment")
	public void user_should_able_to_check_the_payment() {
		OverviewPayment4 overviewpayment4 = new OverviewPayment4(driver);
		overviewpayment4.clickfinish();

		// 8. Verify the Success message -
		String expectedsuccessMsg = "Thank you for your order!";
		String actualsuccessMsg = overviewpayment4.GetsuccessMsg4();
		Assert.assertEquals(actualsuccessMsg, expectedsuccessMsg);

	}

}
