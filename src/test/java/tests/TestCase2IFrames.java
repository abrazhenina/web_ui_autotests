package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserConfig;
import data.TestData;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.*;

public class TestCase2IFrames extends BaseTest {
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	NestedFramesPage nestedFramesPage;
	FramesPage framesPage;
	String text;
	String text2;

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n2 test case started.", true);
		Reporter.log("1/3", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		mainPage = new MainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test(priority = 2)
	void testStep2() {
		Reporter.log("2/3", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickAlertsFrameAndWindowsBtn();
		Reporter.log("AlertsFrameAndWindowsPage displayed.", true);
		alertsWindowsPage = new AlertsWindowsPage();
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click NestedFrames button on AlertsWindowsPage.", true);
		alertsWindowsPage.clickNestedFramesBtn();
		Reporter.log("NestedFramesPage opens.", true);
		nestedFramesPage = new NestedFramesPage();
		Assert.assertTrue(nestedFramesPage.isOpen(), "NestedFramesPage not found.");
		Reporter.log("ParentFrame displayed on NestedFramesPage.", true);
		Assert.assertTrue(nestedFramesPage.isParentFrameOpen(), "ParentFrame not found.");
		text = TestData.getNestedFramesParentFrameText();
		Reporter.log("ParentFrame text is '" + text + "'.", true);
		nestedFramesPage.switchToParentFrame();
		Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), text,
				"Expected text and actual text not equal.");
		Assert.assertTrue(nestedFramesPage.isChildFrameOpen(), "ChildFrame not found.");
		nestedFramesPage.switchToChildFrame();
		Reporter.log("ChildFrame displayed on NestedFramesPage.", true);
		text = TestData.getNestedFramesChildFrameText();
		Reporter.log("ChildFrame text is '" + text + "'.", true);
		Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), text,
				"Expected text and actual text not equal.");
		nestedFramesPage.switchBackFromFrames();
	}

	@Test(priority = 3)
	void testStep3() {
		Reporter.log("3/3", true);
		Reporter.log("Click FramesButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickFramesBtn();
		Reporter.log("FramesPage opens.", true);
		framesPage = new FramesPage();
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