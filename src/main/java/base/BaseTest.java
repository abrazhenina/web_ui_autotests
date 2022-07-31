package base;

import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
	WebDriver driver;
	public BaseTest() {
	}

	@BeforeTest
	void beforeTestRun() {
		BrowserFactory.setParameters();
		driver = Browser.getBrowserInstance();
	}

	@AfterTest
	void afterTestRun() {
		Browser.getBrowserInstance().quit();
	}
}