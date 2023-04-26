package Scenario1Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario1.AddToCard1;
import Scenario1.Checkout;
import Scenario1.LoginPage;
import Scenario1.OverviewPayment;
import Scenario1.YourInfo1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySuccessMessage1 {
	 WebDriver driver;
		
		@BeforeTest
		public void BuyFrom() {
			
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
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsername("standard_user");
			
			// enterpasspord
			loginpage.enterPassword("secret_sauce");
			
			//click login button
			loginpage.clickloginBtn();
			
			// click click fist to add
			AddToCard1 addtocard = new AddToCard1(driver);
			addtocard.clickfirst();
			
			// click  second to add the card
			addtocard.clicksecond();
			
			//click to card icon
			addtocard.clickcardicon();
			
			// click on checkout
			Checkout checkout = new Checkout(driver);
			checkout.clickcheckout();
			
			// enter your info in checkout
			YourInfo1 yourinfo = new YourInfo1(driver);
			yourinfo.enterfirstname("Aman");
			yourinfo.enterlastname("Ahmadyar");
			yourinfo.enterpostalcode(20737);
			yourinfo.clickcontinueBtn();
			
			// click on finish
			OverviewPayment overviewpayment = new OverviewPayment(driver);
			overviewpayment.clickfinish();
	
	// 8. Verify the Success message - 
			String expectedsuccessMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there";
			String actualsuccessMsg =overviewpayment.getsuccessMsg();
			Assert.assertEquals(actualsuccessMsg, expectedsuccessMsg);
		}
		@AfterTest
		public void closebrowser() {
			// 9. Close the browser
			driver.quit();
			
		}
		}