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
	String message;

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
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isPageOpen(),"AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click Alerts button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getAlertsWindowsPageAlertBtnName());
		Reporter.log("AlertsPage opens.", true);

		Assert.assertTrue(alertsPage.isPageOpen(),"AlertsPage not found.");


		Reporter.log("3 step", true);
		Reporter.log("Click 'Button to see alert'", true);
		alertsPage.clickButton(TestData.getToSeeAlertBtnName());
		Reporter.log("Alert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		message = TestData.getToSeeAlertMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("4 step", true);
		Reporter.log("Click AlertWindow OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");

		Reporter.log("5 step", true);
		Reporter.log("Click 'On button click, confirm box will appear'", true);
		alertsPage.clickButton(TestData.getAlertConfirmBoxBtnName());
		Reporter.log("ConfirmBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");

		message = TestData.getAlertConfirmBoxMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");


		//Assert.assertFalse(alertsPage.isAlertDisplayed(), "Alert still displayed.");

	}


	@AfterTest
	void tearDown() {
		driver.quit();
	}
}