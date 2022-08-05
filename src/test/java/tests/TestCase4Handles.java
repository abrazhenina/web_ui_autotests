package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserConfig;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.*;

public class TestCase4Handles extends BaseTest {
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	BrowserWindowsPage browserWindowsPage;
	LinksPage linksPage;

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n4 test case started.", true);
		Reporter.log("1/7", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		mainPage = new MainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test(priority = 2)
	void testStep2() {
		Reporter.log("2/7", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickAlertsFrameAndWindowsBtn();
		alertsWindowsPage = new AlertsWindowsPage();
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click BrowserWindowsButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickBrowserWindowsBtn();
		Reporter.log("BrowserWindowsPage opens.", true);
		browserWindowsPage = new BrowserWindowsPage();
		Assert.assertTrue(browserWindowsPage.isOpen(), "BrowserWindowsPage not found.");
	}

	@Test(priority = 3)
	void testStep3() {
		Reporter.log("3/7", true);
		Reporter.log("Click NewTabButton.", true);
		browserWindowsPage.clickNewTabBtn();
		Reporter.log("Check the URL of new tab contains '/sample'", true);
		Assert.assertTrue(browserWindowsPage.isSubstringInCurrentUrl("/sample"), "'/sample' not found in the URL.");
	}

	@Test(priority = 4)
	void testStep4() {
		Reporter.log("4/7", true);
		Reporter.log("Close this tab.", true);
		browserWindowsPage.closeCurrentTab();
		Reporter.log("On the current tab is BrowserWindowsPage.", true);
		Assert.assertTrue(browserWindowsPage.isOpen(), "BrowserWindowsPage not found.");
	}

	@Test(priority = 5)
	void testStep5() {
		Reporter.log("5/7", true);
		Reporter.log("Click ElementsButton.", true);
		browserWindowsPage.clickElementsHeaderBtn();
		Assert.assertTrue(browserWindowsPage.isElementsDropdownShowed(), "ElementsDropdown not found.");
		Reporter.log("Click LinksButton.", true);
		browserWindowsPage.clickLinksBtn();
		Reporter.log("LinksPage opens.", true);
		Assert.assertTrue(linksPage.isOpen(), "LinksPage not found.");
	}

	@Test(priority = 6)
	void testStep6() {
		Reporter.log("6/7", true);
		Reporter.log("Click HomeLink.", true);
		linksPage = new LinksPage();
		linksPage.clickHomeLink();
		Reporter.log("New tab with MainPage opens.", true);
		Reporter.log("MainPage is open.", true);
	}

	@Test(priority = 7)
	void testStep7() {
		Reporter.log("7/7", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
		Reporter.log("Switch to previous tab.", true);
		linksPage.switchToPrevPage();
		Reporter.log("LinksPage opens.", true);
		Assert.assertTrue(linksPage.isOpen(), "LinksPage not found.");
	}
}