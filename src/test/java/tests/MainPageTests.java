package tests;

import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.testng.Assert;
import pageObjects.AlertsPage;
import pageObjects.AlertsWindowsPage;
import pageObjects.MainPage;
import pageObjects.NestedFramesPage;
import utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageTests {
	WebDriver driver;
	String testDataPath = "src/test/resources/testData.json";
	String configPath = "src/test/resources/config.json";
	TestData testData;
	Config config;
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	AlertsPage alertsPage;
	NestedFramesPage nestedFramesPage;
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
		nestedFramesPage = new NestedFramesPage();
	}

	/*
	@Test(priority = 1)
	void testCase1() {
		Reporter.log("1 test case started.", true);
		Reporter.log("1/8", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isPageOpen(), "MainPage not found.");

		Reporter.log("2/8", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isPageOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click Alerts button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getAlertsWindowsPageAlertBtnName());
		Reporter.log("AlertsPage opens.", true);
		Assert.assertTrue(alertsPage.isPageOpen(), "AlertsPage not found.");

		Reporter.log("3/8", true);
		Reporter.log("Click 'Button to see alert'", true);
		alertsPage.clickButton(TestData.getToSeeAlertBtnName());
		Reporter.log("Alert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		message = TestData.getToSeeAlertMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("4/8", true);
		Reporter.log("Click AlertWindow OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");

		Reporter.log("5/8", true);
		Reporter.log("Click 'On button click, confirm box will appear'", true);
		alertsPage.clickButton(TestData.getAlertConfirmBoxBtnName());
		Reporter.log("ConfirmBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		message = TestData.getAlertConfirmBoxMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("6/8", true);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		message = TestData.getAlertConfirmResultLabelText();
		Reporter.log("ConfirmResultLabel text '"+message+"' displayed.", true);
		Assert.assertEquals(alertsPage.getLabelText(TestData.getAlertConfirmResultLabelName()),
				TestData.getAlertConfirmResultLabelText(),
				"ConfirmResultText and TestDataText not equal.");

		Reporter.log("7/8", true);
		Reporter.log("Click 'On button click, prompt box will appear'", true);
		alertsPage.clickButton(TestData.getAlertPromptBoxBtnName());
		Reporter.log("PromptBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		message = TestData.getAlertPromptBoxMessage();
		Reporter.log("Alert message is '" + message + "'", true);
		Assert.assertEquals(message, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("8/8", true);
		Reporter.log("Send random string to PromptBoxAlert.", true);
		message = StringUtil.getRandomString();
		alertsPage.sendKeysToAlertPrompt(message);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		Reporter.log("Random string '"+message+"' displayed in the PromptLabel.", true);
		Assert.assertTrue(StringUtil.strContainsSub(alertsPage
				.getLabelText(TestData.getAlertPromptResultLabelName()), message),
				"Randomly generated string not found in AlertPromptResultLabel.");
	}

	 */

	@Test(priority = 2)
	void testCase2() {
		Reporter.log("2 test case started.", true);
		Reporter.log("1/3", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isPageOpen(), "MainPage not found.");

		Reporter.log("2/3", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isPageOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click NestedFrames button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getNestedFramesBtnName());
		Reporter.log("NestedFramesPage opens.", true);
		Assert.assertTrue(nestedFramesPage.isPageOpen(), "NestedFramesPage not found.");
		String frameName = TestData.getNestedFramesParentFrameName();
		Reporter.log("'"+frameName+"' displayed on NestedFramesPage.", true);
		message = TestData.getNestedFramesParentFrameText();
		Reporter.log(frameName+" text is '"+message+"'.", true);
		Assert.assertTrue(nestedFramesPage.isFrameOpen());
		//Assert.assertEquals(nestedFramesPage.getElementText(frameName), message,
		//		"Expected text and actual text not equal.");
	}

	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}
}