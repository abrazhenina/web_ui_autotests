package tests;

import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.testng.Assert;
import pageObjects.*;
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
	String name;
	String text;
	String text2;
	FramesPage framesPage;
	ElementsPage elementsPage;
	WebTablesPage webTablesPage;
	RegistrationForm registrationForm;

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
		framesPage = new FramesPage();
		elementsPage = new ElementsPage();
		webTablesPage = new WebTablesPage();
		registrationForm = new RegistrationForm();
	}

	@Test(priority = 3)
	void testCase3() {
		Reporter.log("3 test case started.", true);
		Reporter.log("1/5", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isPageOpen(), "MainPage not found.");

		Reporter.log("2/5", true);
		Reporter.log("Click ElementsButton.", true);
		mainPage.clickButton("elementsBtn");
		Reporter.log("ElementsPage opens.", true);
		Assert.assertTrue(elementsPage.isPageOpen(), "ElementsPage not found.");
		Reporter.log("Click WebTablesButton.", true);
		elementsPage.clickButton("webTablesBtn");
		Reporter.log("WebTablesPage opens.", true);
		Assert.assertTrue(webTablesPage.isPageOpen());
		Reporter.log("Click AddButton.", true);
		webTablesPage.clickButton("addBtn");
		Reporter.log("RegistrationForm opens.", true);
		Assert.assertTrue(registrationForm.isRegFormContentVisible());

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
		Reporter.log("AlertsFrameAndWindowsPage displayed.", true);
		Assert.assertTrue(alertsWindowsPage.isPageOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click NestedFrames button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getNestedFramesBtnName());
		Reporter.log("NestedFramesPage opens.", true);
		Assert.assertTrue(nestedFramesPage.isPageOpen(), "NestedFramesPage not found.");
		name = TestData.getNestedFramesParentFrameName();
		Reporter.log("'"+ name +"' displayed on NestedFramesPage.", true);
		Assert.assertTrue(nestedFramesPage.isParentFrameOpen(), "ParentFrame not found.");
		text = TestData.getNestedFramesParentFrameText();
		Reporter.log(name +" text is '"+ text +"'.", true);
		nestedFramesPage.switchToParentFrame();
		Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), text,
				"Expected text and actual text not equal.");
		Assert.assertTrue(nestedFramesPage.isChildFrameOpen(), "ChildFrame not found.");
		nestedFramesPage.switchToChildFrame();
		name = TestData.getNestedFramesChildFrameName();
		Reporter.log("'"+ name +"' displayed on NestedFramesPage.", true);
		text = TestData.getNestedFramesChildFrameText();
		Reporter.log(name +" text is '"+ text +"'.", true);
		Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), text,
				"Expected text and actual text not equal.");
		nestedFramesPage.switchBackFromFrames();

		Reporter.log("3/3", true);
		Reporter.log("Click FramesButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton("framesBtn");
		Reporter.log("FramesPage opens.", true);
		Assert.assertTrue(framesPage.isPageOpen(), "FramesPage not found.");
		Reporter.log("UpperFrame on FramesPage displayed.", true);
		Assert.assertTrue(framesPage.isUpperFrameOpen(), "UpperFrame not found.");
		Reporter.log("Switch to UpperFrame.", true);
		framesPage.switchToUpperFrame();
		Reporter.log("Read UpperFrame text.", true);
		text = framesPage.getTextFromUpperFrame();
		Reporter.log("Switch back from frame.", true);
		framesPage.switchBackFromFrames();
		Reporter.log("LowerFrame on FramesPage displayed.", true);
		Assert.assertTrue(framesPage.isLowerFrameOpen(), "LowerFrame not found.");
		Reporter.log("Switch to LowerFrame.", true);
		framesPage.switchToLowerFrame();
		Reporter.log("Read LowerFrame text.", true);
		text2 = framesPage.getTextFromLowerFrame();
		Reporter.log("Switch back from frame.", true);
		framesPage.switchBackFromFrames();
		Reporter.log("UpperFrameText and LowerFrameText equal.", true);
		Assert.assertEquals(text, text2, "Texts not equal.");
	}
 */



	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}
}