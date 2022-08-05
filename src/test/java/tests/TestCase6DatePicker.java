package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserConfig;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.WidgetsPage;

public class TestCase6DatePicker extends BaseTest {
	private MainPage mainPage;
	private WidgetsPage widgetsPage;

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n6 test case started.", true);
		Reporter.log("\n1/3", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		mainPage = new MainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test(priority = 2)
	void testStep2() {
		Reporter.log("\n2/3", true);
		Reporter.log("Click WidgetsButton.", true);
		mainPage.clickWidgetsBtn();
		Reporter.log("WidgetsPage opens.", true);
		widgetsPage = new WidgetsPage();
		Assert.assertTrue(widgetsPage.isOpen(), "WidgetsPage not found.");
		Reporter.log("Click DatePickerButton.", true);
		widgetsPage.clickDatePickerBtn();
		Reporter.log("DatePickerForm opens.", true);
		Assert.assertTrue(widgetsPage.isDatePickerFormOpen(), "DatePickerForm not found.");
		Reporter.log("The date in DatePickerForm DateInput is actual.", true);
		Assert.assertTrue(widgetsPage.isDatePickerDateActual(), "Date not actual.");
		Reporter.log("The date and time in DatePickerForm DateTimeInput is actual.", true);
		Assert.assertTrue(widgetsPage.isDatePickerDateTimeActual(), "Date and time not actual.");
	}

	@Test(priority = 3)
	void testStep3() {
		Reporter.log("\n3/3", true);
		Reporter.log("DatePickerCalendar opens.", true);
		widgetsPage.openDateCalendar();
		Assert.assertTrue(widgetsPage.isDateCalendarOpen(), "DatePickerCalendar not found.");
		Reporter.log("Pick 29 February closest to current day.", true);
		widgetsPage.pickClosest29Fev();
		Reporter.log("In the DatePicker DateInput is 29 February.", true);
		Assert.assertTrue(widgetsPage.isDatePickerDate29Fev(), "DatePickerDate is not February 29.");
	}
}