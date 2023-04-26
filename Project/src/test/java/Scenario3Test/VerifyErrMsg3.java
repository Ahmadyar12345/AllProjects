package Scenario3Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario3.AddToCard3;
import Scenario3.Checkout3;
import Scenario3.LoginPage3;
import Scenario3.YourInfo3;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyErrMsg3 {

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
			LoginPage3 loginpage = new LoginPage3(driver);
			loginpage.enterUsername("problem_user");
			
			// enterpasspord
			loginpage.enterPassword("secret_sauce");
			
			//click login button
			loginpage.clickloginBtn();
			
			// click click fist to add
			AddToCard3 addtocard3 = new AddToCard3(driver);			
			addtocard3.clickfirst();
			
			//click to card icon
			addtocard3.clickcardicon();
			
			// click on checkout
			Checkout3 checkout3 = new Checkout3(driver);
			checkout3.clickcheckout3();
			
			// enter your info in checkout
			YourInfo3 yourinfo = new YourInfo3(driver);
			yourinfo.enterfirstname("Aman");
			yourinfo.enterlastname("Ahmadyar");
			yourinfo.enterpostalcode(20737);
			yourinfo.clickcontinue();
			
			//Verify Err message - 
			String expectedErrMsg = "Error: Last Name is required";
			String actualErrMsg =yourinfo.GetErrMsg();
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
			
		}
		@AfterTest
		public void closebrowser() {
			// 9. Close the browser
			driver.quit();
			
		}
}
