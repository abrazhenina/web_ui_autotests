package tests;

import base.BaseTest;
import browser.Browser;
import browser.BrowserConfig;
import data.TestData;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pageObjects.*;

public class TestCase3WebTables extends BaseTest {
	MainPage mainPage;
	ElementsPage elementsPage;
	WebTablesPage webTablesPage;
	RegistrationForm registrationForm;
	String userNum;
	String userFirstName;

	@Test (priority = 1)
	void testStep1() {
		Reporter.log("\n3 test case started.", true);
		Reporter.log("1/5", true);
		Reporter.log("Go to MainPage.", true);
		Browser.getBrowserInstance();
		Browser.goToUrl(BrowserConfig.getHomePageAddress());
		Reporter.log("MainPage is open.", true);
		mainPage = new MainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
	}

	@Test (priority = 2)
	void testStep2() {
		Reporter.log("\n2/5", true);
		Reporter.log("Click ElementsButton.", true);
		mainPage.clickElementsBtn();
		Reporter.log("ElementsPage opens.", true);
		elementsPage = new ElementsPage();
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		Reporter.log("Click WebTablesButton.", true);
		elementsPage.clickWebTablesBtn();
		Reporter.log("WebTablesPage opens.", true);
		webTablesPage = new WebTablesPage();
		Assert.assertTrue(webTablesPage.isOpen(), "WebTablesPage not found.");
	}

	@Test (priority = 3)
	void testStep3() {
		Reporter.log("\n3/5", true);
		Reporter.log("Click AddButton.", true);
		webTablesPage.clickAddBtn();
		Reporter.log("RegistrationForm opens.", true);
		registrationForm = new RegistrationForm();
		Assert.assertTrue(registrationForm.isRegFormVisible(), "RegForm not found.");
	}

	@Test (priority = 4)
	void testStep4() {
		Reporter.log("\n4/5", true);
		userNum = Integer.toString(TestData.getUserNum());
		Reporter.log("Fill the registration form with data of user #" + userNum, true);
		Reporter.log("Fill the first name.", true);
		String userFirstName = TestData.getUserFirstName();
		registrationForm.sendKeysFirstName(userFirstName);
		//Assert.assertTrue(registrationForm.isFirstNameFilled(), "FirstNameInput not filled.");
		Reporter.log("Fill the last name.", true);
		String userLastName = TestData.getUserLastName();
		registrationForm.sendKeysLastName(userLastName);
		//Assert.assertTrue(registrationForm.isLastNameFilled(), "LastNameInput not filled.");
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
		Reporter.log("Delete user #"+userNum+" WebTable record.", true);
		webTablesPage.deleteRecord();
		Assert.assertTrue(webTablesPage.isRecordDeleted(userFirstName),"User data still in WebTable.");
	}
}