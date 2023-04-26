package Scenario1Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver;

	@BeforeTest
	public void launchApplication() {

		// 1. open the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// 2. Maximize it
		driver.manage().window().maximize();

		// 3. navigate the Application
		driver.get("https://www.saucedemo.com/");
	}
	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
}
