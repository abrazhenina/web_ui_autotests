package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;
import pageObjects.AlertsWindowsPage;
import pageObjects.MainPage;
import utils.JsonReader;
import utils.StringUtil;

import java.io.IOException;

public class TC1Alerts extends BaseTest {
	WebDriver driver;
	static String testDataPath = "src/test/resources/testData.json";
	static String configPath = "src/test/resources/config.json";
	static TestData testData;
	static Config config;
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	AlertsPage alertsPage;
	String text;

	@BeforeTest
	void setup() {
		try {
			config = new Config(JsonReader.readJson(configPath));
			testData = new TestData(JsonReader.readJson(testDataPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BrowserFactory.setParameters();
		driver = Browser.getBrowserInstance();
		mainPage = new MainPage();
		alertsWindowsPage = new AlertsWindowsPage();
		alertsPage = new AlertsPage();
	}

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("1 test case started.", true);
		Reporter.log("\n1/8", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test (priority = 2)
	void testStep2() {
		Reporter.log("\n2/8", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click AlertsButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getAlertsWindowsPageAlertBtnName());
		Reporter.log("AlertsPage opens.", true);
		Assert.assertTrue(alertsPage.isOpen(), "AlertsPage not found.");
	}

	@Test (priority = 3)
	void testStep3() {
		Reporter.log("\n3/8", true);
		Reporter.log("Click 'Button to see alert'", true);
		alertsPage.clickButton(TestData.getToSeeAlertBtnName());
		Reporter.log("Alert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		text = TestData.getToSeeAlertMessage();
		Reporter.log("Alert message is '"+text+"'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");
	}

	@Test (priority = 4)
	void testStep4() {
		Reporter.log("\n4/8", true);
		Reporter.log("Click AlertWindow OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
	}

	@Test (priority = 5)
	void testStep5() {
		Reporter.log("\n5/8", true);
		Reporter.log("Click 'On button click, confirm box will appear'", true);
		alertsPage.clickButton(TestData.getAlertConfirmBoxBtnName());
		Reporter.log("ConfirmBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		text = TestData.getAlertConfirmBoxMessage();
		Reporter.log("Alert message is '"+text+"'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");
	}

	@Test (priority = 6)
	void testStep6() {
		Reporter.log("\n6/8", true);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		text = TestData.getAlertConfirmResultLabelText();
		Reporter.log("ConfirmResultLabel text '"+text+"' displayed.", true);
		Assert.assertEquals(alertsPage.getLabelText(TestData.getAlertConfirmResultLabelName()),
				TestData.getAlertConfirmResultLabelText(),
				"ConfirmResultText and TestDataText not equal.");
	}

	@Test (priority = 7)
	void testStep7() {
		Reporter.log("\n7/8", true);
		Reporter.log("Click 'On button click, prompt box will appear'", true);
		alertsPage.clickButton(TestData.getAlertPromptBoxBtnName());
		Reporter.log("PromptBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		text = TestData.getAlertPromptBoxMessage();
		Reporter.log("Alert message is '" + text + "'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");
	}

	@Test (priority = 8)
	void testStep8() {
		Reporter.log("\n8/8", true);
		Reporter.log("Send random string to PromptBoxAlert.", true);
		text = StringUtil.getRandomString();
		alertsPage.sendKeysToAlertPrompt(text);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		System.out.println("'"+text+"'");
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		Reporter.log("Random string '"+text+"' displayed in the PromptLabel.", true);
		Assert.assertTrue(StringUtil.strContainsSub(alertsPage
						.getLabelText(TestData.getAlertPromptResultLabelName()), text),
				"Randomly generated string not found in AlertPromptResultLabel.");
	}
}