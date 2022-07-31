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

public class TC3WebTables extends BaseTest {
	WebDriver driver;
	static String testDataPath = "src/test/resources/testData.json";
	static String configPath = "src/test/resources/config.json";
	static TestData testData;
	static Config config;
	MainPage mainPage;
	ElementsPage elementsPage;
	WebTablesPage webTablesPage;
	RegistrationForm registrationForm;
	int userNum;
	String userFirstName;

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
		elementsPage = new ElementsPage();
		webTablesPage = new WebTablesPage();
		registrationForm = new RegistrationForm();
	}

	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}

	@Test (priority = 1)
	void testStep1() {
		Reporter.log("\n3 test case started.", true);
		Reporter.log("1/5", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test (priority = 2)
	void testStep2() {
		Reporter.log("2/5", true);
		Reporter.log("Click ElementsButton.", true);
		mainPage.clickButton("elementsBtn");
		Reporter.log("ElementsPage opens.", true);
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		Reporter.log("Click WebTablesButton.", true);
		elementsPage.clickButton("webTablesBtn");
		Reporter.log("WebTablesPage opens.", true);
		Assert.assertTrue(webTablesPage.isOpen());
	}

	@Test (priority = 3)
	void testStep3() {
		Reporter.log("3/5", true);
		Reporter.log("Click AddButton.", true);
		webTablesPage.clickButton("addBtn");
		Reporter.log("RegistrationForm opens.", true);
		Assert.assertTrue(registrationForm.isRegFormVisible());
	}

	@Test (priority = 4)
	void testStep4() {
		Reporter.log("4/5", true);
		String userNum = Integer.toString(TestData.getUserNum());
		Reporter.log("Fill the registration form with data of user #" + userNum, true);
		Reporter.log("Fill the first name.", true);
		String userFirstName = TestData.getUserFirstName();
		registrationForm.sendKeysFirstName(userFirstName);
		Reporter.log("Fill the last name.", true);
		String userLastName = TestData.getUserLastName();
		registrationForm.sendKeysLastName(userLastName);
		Reporter.log("Fill the email.", true);
		registrationForm.sendKeysEmail(TestData.getUserEmail());
		Reporter.log("Fill the age.", true);
		registrationForm.sendKeysAge(Integer.toString(TestData.getUserAge()));
		Reporter.log("Fill the salary.", true);
		registrationForm.sendKeysSalary(Integer.toString(TestData.getUserSalary()));
		Reporter.log("Fill the department.", true);
		registrationForm.sendKeysDepartment(TestData.getUserDepartment());
		Reporter.log("Press submit button.", true);
		registrationForm.clickSubmit();
		Assert.assertFalse(registrationForm.isRegFormClosed(), "Registration form didn't close.");
		Assert.assertTrue(webTablesPage.isRecordInTable(userFirstName), "User not found in WebTable.");
	}

	@Test (priority = 5)
	void testStep5() {
		Reporter.log("5/5", true);
		Reporter.log("Delete user  #"+userNum+" WebTable record.", true);
		webTablesPage.deleteRecord();
		Assert.assertTrue(webTablesPage.isRecordDeleted(userFirstName),"User data still in WebTable.");
	}
}