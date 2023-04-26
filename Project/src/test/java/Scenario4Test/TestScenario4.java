package Scenario4Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario1Test.BaseTest;
import Scenario4.Checkout4;
import Scenario4.LoginPage4;
import Scenario4.OverviewPayment4;
import Scenario4.SortLowToHigh;
import Scenario4.YourInfo4;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario4 extends BaseTest {

	WebDriver driver;

	@BeforeTest
	public void BuyFrom() {
		// 1. open the browser
		 ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");

         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver(option);

		// 2. Maximize it
		driver.manage().window().maximize();

		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");

	}

	@Test
	public void BuyFromS() {
		// enter username
		LoginPage4 loginpage4 = new LoginPage4(driver);
		loginpage4.enterUsername("standard_user");

		// enterpasspord
		loginpage4.enterPassword("secret_sauce");

		// click login button
		loginpage4.clickloginBtn();

		// sort the price of product from low to high
		SortLowToHigh sortlowtohigh = new SortLowToHigh(driver);
		sortlowtohigh.NameAToZ();

		sortlowtohigh.PricelowTohigh();
		sortlowtohigh.clickiconcard();

		// click on checkout
		Checkout4 checkout = new Checkout4(driver);
		checkout.clickcheckout();
		
		// enter your info in checkout
		YourInfo4 yourinfo = new YourInfo4(driver);
		yourinfo.enterfirstname("Aman");
		yourinfo.enterlastname("Ahmadyar");
		yourinfo.enterpostalcode(20737);
		yourinfo.clickcontinue();
		
		// check paymentinfo
		OverviewPayment4 overviewpayment4 = new OverviewPayment4(driver);
		overviewpayment4.clickfinish();
		
	}

	@AfterTest
	public void closebrowser() {
		// 9. Close the browser
		driver.quit();
	}
}
