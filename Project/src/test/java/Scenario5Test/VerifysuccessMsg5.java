package Scenario5Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario5.Addproduct;
import Scenario5.Checkout5;
import Scenario5.ContinueBtn;
import Scenario5.Finish5;
import Scenario5.LoginPage5;
import Scenario5.SortHighToLow;
import Scenario5.YourInfo5;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifysuccessMsg5 {

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
	public void BuyFromS() throws InterruptedException {
		// enter username
		LoginPage5 loginpage = new LoginPage5(driver);
		loginpage.enterUsername("standard_user");

		// enterpasspord
		loginpage.enterPassword("secret_sauce");

		// click login button
		loginpage.clickloginBtn();

		// add product
		Addproduct addproduct = new Addproduct(driver);
		addproduct.addfirst();
		addproduct.addthird();
		addproduct.removefirst();

		// click continueBtn
		ContinueBtn continueBtn = new ContinueBtn(driver);
		continueBtn.displayed();
		// continueBtn.clickcontiueshopping();

		// sort price from high to low
		SortHighToLow sorthightolow = new SortHighToLow(driver);
		sorthightolow.Pricehightolow();
		sorthightolow.firstitem();
		sorthightolow.seconditem();
		sorthightolow.veriyitems();
		sorthightolow.clickcardicon();

		// click on checkout
		Checkout5 checkout = new Checkout5(driver);
		checkout.clickcheckout();

		// enter your info in checkout
		YourInfo5 yourinfo = new YourInfo5(driver);
		yourinfo.enterfirstname("Aman");
		yourinfo.enterlastname("Ahmadyar");
		yourinfo.enterpostalcode(20737);

		// click on finish Btn

		Finish5 finish5 = new Finish5(driver);
		finish5.clickfinish();

		// Verify the Success message -
		String expectedsuccessMsg = "Thank you for your order!";
		String actualsuccessMsg = finish5.getsuccessMsg5();
		Assert.assertEquals(actualsuccessMsg, expectedsuccessMsg);
	}

	@AfterTest
	public void closebrowser() {
		// 9. Close the browser
		//driver.quit();

	}
}
