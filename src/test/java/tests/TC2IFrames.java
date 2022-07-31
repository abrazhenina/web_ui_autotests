package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.JsonReader;

import java.io.IOException;

public class TC2IFrames extends BaseTest {
	WebDriver driver;
	static String testDataPath = "src/test/resources/testData.json";
	static String configPath = "src/test/resources/config.json";
	static TestData testData;
	static Config config;
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	NestedFramesPage nestedFramesPage;
	FramesPage framesPage;
	String text;
	String text2;
	String name;

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
		nestedFramesPage = new NestedFramesPage();
		framesPage = new FramesPage();
	}

	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n2 test case started.", true);
		Reporter.log("1/3", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test(priority = 2)
	void testStep2() {
		Reporter.log("2/3", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Reporter.log("AlertsFrameAndWindowsPage displayed.", true);
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click NestedFrames button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getNestedFramesBtnName());
		Reporter.log("NestedFramesPage opens.", true);
		Assert.assertTrue(nestedFramesPage.isOpen(), "NestedFramesPage not found.");
		name = TestData.getNestedFramesParentFrameName();
		Reporter.log("'" + name + "' displayed on NestedFramesPage.", true);
		Assert.assertTrue(nestedFramesPage.isParentFrameOpen(), "ParentFrame not found.");
		text = TestData.getNestedFramesParentFrameText();
		Reporter.log(name + " text is '" + text + "'.", true);
		nestedFramesPage.switchToParentFrame();
		Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), text,
				"Expected text and actual text not equal.");
		Assert.assertTrue(nestedFramesPage.isChildFrameOpen(), "ChildFrame not found.");
		nestedFramesPage.switchToChildFrame();
		name = TestData.getNestedFramesChildFrameName();
		Reporter.log("'" + name + "' displayed on NestedFramesPage.", true);
		text = TestData.getNestedFramesChildFrameText();
		Reporter.log(name + " text is '" + text + "'.", true);
		Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), text,
				"Expected text and actual text not equal.");
		nestedFramesPage.switchBackFromFrames();
	}

	@Test(priority = 3)
	void testStep3() {
		Reporter.log("3/3", true);
		Reporter.log("Click FramesButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton("framesBtn");
		Reporter.log("FramesPage opens.", true);
		Assert.assertTrue(framesPage.isOpen(), "FramesPage not found.");
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
}