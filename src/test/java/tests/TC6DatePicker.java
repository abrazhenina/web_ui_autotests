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
import pageObjects.FramesPage;
import pageObjects.MainPage;
import pageObjects.NestedFramesPage;
import pageObjects.WidgetsPage;
import utils.JsonReader;
import utils.TimeUtil;

import java.io.IOException;

public class TC6DatePicker extends BaseTest {
	private WebDriver driver;
	private String testDataPath = "src/test/resources/testData.json";
	private String configPath = "src/test/resources/config.json";
	private TestData testData;
	private Config config;
	private MainPage mainPage;
	private NestedFramesPage nestedFramesPage;
	private FramesPage framesPage;
	private WidgetsPage widgetsPage;

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
		nestedFramesPage = new NestedFramesPage();
		framesPage = new FramesPage();
		widgetsPage = new WidgetsPage();
	}

	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}

	@Test(priority = 1)
	void testStep1() {
		Reporter.log("\n5 test case started.", true);
		Reporter.log("\n1/6", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test(priority = 2)
	void testStep2() {
		Reporter.log("\n2/6", true);
		Reporter.log("Click WidgetsButton.", true);
		mainPage.clickButton("widgetsBtn");
		Reporter.log("WidgetsPage opens.", true);
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
	void testStep3() throws InterruptedException {
		Reporter.log("DatePickerCalendar opens.", true);
		widgetsPage.openDateCalendar();
		Assert.assertTrue(widgetsPage.isDateCalendarOpen(), "DatePickerCalendar not found.");
		widgetsPage.pickClosest29Fev();
		Assert.assertTrue(widgetsPage.isDatePickerDate29Fev(), "DatePickerDate is not February 29.");
		Thread.sleep(1000);
	}
}