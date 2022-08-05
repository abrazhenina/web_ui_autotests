package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserConfig;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.*;

public class TestCase7Files extends BaseTest {
	private MainPage mainPage;
	private ElementsPage elementsPage;

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n7 test case started.", true);
		Reporter.log("\n1/4", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		mainPage = new MainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test (priority = 2)
	void testStep2() {
		Reporter.log("2/4", true);
		Reporter.log("Click ElementsButton.", true);
		mainPage.clickElementsBtn();
		Reporter.log("ElementsPage opens.", true);
		elementsPage = new ElementsPage();
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		Reporter.log("Click UploadDownloadBtn.", true);
		elementsPage.clickUploadDownloadBtn();
		Reporter.log("UploadDownloadForm opens.", true);
		Assert.assertTrue(elementsPage.isUploadDownloadFormOpen(), "UploadDownloadForm not found.");
	}

	@Test (priority = 3)
	void testStep3() {
		Reporter.log("3/4", true);
		Reporter.log("Click DownloadBtn.", true);
		elementsPage.clickDownloadBtn();
	}
}