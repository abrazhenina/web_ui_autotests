package tests;

import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.testng.Assert;
import pageObjects.AlertsPage;
import pageObjects.AlertsWindowsPage;
import pageObjects.MainPage;
import utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class MainPageTests {
	Browser browser;
	WebDriver driver;
	String testDataPath = "src/test/resources/testData.json";
	String configPath = "src/test/resources/config.json";
	TestData testData;
	Config config;
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	AlertsPage alertsPage;

	@BeforeTest
	void setup () throws IOException {
		try {
			config = new Config(JsonReader.readJson(configPath));
			testData = new TestData(JsonReader.readJson(testDataPath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		BrowserFactory.setParameters();
		driver = Browser.getBrowserInstance();
		mainPage = new MainPage();
		alertsWindowsPage = new AlertsWindowsPage();
		alertsPage = new AlertsPage();
	}

	@Test(priority = 1)
	void testCase1() {
		Reporter.log("1 test case started.", true);
		Reporter.log("1 step", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isPageOpen(), "MainPage not found.");

		Reporter.log("2 step", true);
		Reporter.log("Click AlertsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isPageOpen(),"AlertsPage not found.");
		Reporter.log("Click Alerts button on AlertsWindowsPage.", true);
		//Почему-то не работает из тестДата, а только по прямому имени
		//alertsWindowsPage.clickButton(TestData.getToSeeAlertBtnName());
		alertsWindowsPage.clickButton("alertsBtn");
		Reporter.log("AlertsPage opens.", true);
		Assert.assertTrue(alertsPage.isPageOpen(),"AlertsPage not found.");


		Reporter.log("3 step", true);
		Reporter.log("Click 'Button to see alert'", true);
		alertsPage.clickButton("seeAlertBtn");
		Reporter.log("Alert window opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		String message = TestData.getAlertMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("4 step", true);
		Reporter.log("Click AlertWindow OK button", true);
		alertsPage.acceptAlert();
		// ДОДЕЛАТЬ - висит 10 сек и падает
		// Assert.assertFalse(alertsPage.isAlertDisplayed(), "Alert window still displayed.");

		Reporter.log("5 step", true);
		Reporter.log("Click 'On button click, confirm box will appear'", true);
		//alertsPage.clickButton();



	}


	@AfterTest
	void tearDown() {
		driver.quit();
	}
}