package tests;

import base.BaseTest;
import browser.Browser;
import config.Config;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import utils.JsonReader;

import java.io.IOException;

public class MainPageTests extends BaseTest {
	Browser browser;
	WebDriver driver;
	WebDriverWait wait;
	String testDataPath = "src/test/resources/testData.json";
	String configPath = "src/test/resources/config.json";
	TestData testData;
	Config config;
	MainPage mainPage;

	public MainPageTests(WebDriver driver, Config config) {
		super(driver, config);
	}

	@BeforeTest
	void beforeTestRun() {
		try {
			config = new Config(JsonReader.readJson(configPath));
			testData = new TestData(JsonReader.readJson(testDataPath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		mainPage = new MainPage();
	}

	@Test(priority = 1)
	void alertsTest() {
		// 1
		Reporter.log("Open HomePage.", true);
		Browser.goToUrl(driver, config.homePageAddress);
	}


	@AfterTest
	void afterTestRun(){
		driver.quit();
	}
}
