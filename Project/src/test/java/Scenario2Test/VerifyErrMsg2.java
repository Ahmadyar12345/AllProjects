package Scenario2Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario2.LoginPage2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyErrMsg2 {
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
			LoginPage2 loginpage2 = new LoginPage2(driver);
			loginpage2.enterUsername("locked_out_user");

			// enterpasspord
			loginpage2.enterPassword("secret_sauce");

			// click login button
			loginpage2.clickloginBtn();
			
			// Verify Err message
			String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out";
			String actualErrMsg = loginpage2.getErrMsg();
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
		}
		@AfterTest
		public void closebrowser() {
			// 9. Close the browser
			driver.quit();
		}

	}
		

