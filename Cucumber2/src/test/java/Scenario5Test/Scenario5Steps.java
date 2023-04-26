package Scenario5Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import Scenario5Pages.Addproduct;
import Scenario5Pages.Checkout5;
import Scenario5Pages.ContinueBtn;
import Scenario5Pages.Finish5;
import Scenario5Pages.LoginPage5;
import Scenario5Pages.SortHighToLow;
import Scenario5Pages.YourInfo5;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5Steps {
	WebDriver driver;
	
	@Given("able to check all items price and select them")
	public void able_to_check_all_items_price_and_select_them() {
		 ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");

         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver(option);
		
		// 2. Maximize it
		driver.manage().window().maximize();
		// 3. Navigate to application
		driver.get("https://www.saucedemo.com/");
	 
	}

	@When("User should able to login")
	public void user_should_able_to_login() {
		LoginPage5 loginpage = new LoginPage5(driver);
		loginpage.enterPassword("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickloginBtn();
	  
	}

	@When("User should be able add the items to card")
	public void user_should_be_able_add_the_items_to_card() {
		Addproduct addproduct = new Addproduct(driver);
		addproduct.addfirst();
		addproduct.addthird();
		addproduct.removefirst();
		
	  
	}

	@When("able to continue shopping")
	public void able_to_continue_shopping() {
		ContinueBtn continueBtn = new ContinueBtn(driver);
		continueBtn.displayed();
	}

	@When("User should able to sort items form high to low")
	public void user_should_able_to_sort_items_form_high_to_low() {
		SortHighToLow sorthightolow = new SortHighToLow(driver);
		sorthightolow.Pricehightolow();
		sorthightolow.firstitem();
		sorthightolow.seconditem();
		sorthightolow.veriyitems();
		sorthightolow.clickcardicon();
	    
	}

	@When("should checkout")
	public void should_checkout() {
		Checkout5 checkout = new Checkout5(driver);
		checkout.clickcheckout();
	   
	}

	@When("able to enter his information")
	public void able_to_enter_his_information() {
		YourInfo5 yourinfo5 = new YourInfo5(driver);
		yourinfo5.enterfirstname("Aman");
		yourinfo5.enterlastname("Ahmadyar");
		yourinfo5.enterpostalcode(20737);
		yourinfo5.clickcontinue();
	 
	}

	@Then("click to finish and able to see the success message")
	public void click_to_finish_and_able_to_see_the_success_message() {
		Finish5 finish = new Finish5(driver);
		finish.clickfinish();
		
		String expectedsuccessMsg = "Thank you for your order!";
		String actualsuccessMsg = finish.getsuccessMsg5();
		Assert.assertEquals(actualsuccessMsg, expectedsuccessMsg);
		
		driver.quit();
	  
	}


}
