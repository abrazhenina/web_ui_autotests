package tests;

import base.BaseTest;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.*;

public class TestCaseDemoQA extends BaseTest {
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	AlertsPage alertsPage;
	String randomStr;
	NestedFramesPage nestedFramesPage;
	FramesPage framesPage;
	String text;
	String text2;
	ElementsPage elementsPage;
	WebTablesPage webTablesPage;
	RegistrationForm registrationForm;
	String userNum;
	String userFirstName;
	BrowserWindowsPage browserWindowsPage;
	LinksPage linksPage;
	WidgetsPage widgetsPage;

	//@Test(priority = 1)
	void alerts() {
		Log.log().info("1 test case started.");
		Log.log().info("1/8");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/8");
		mainPage.clickAlertsFrameAndWindowsBtn();
		alertsWindowsPage = new AlertsWindowsPage();
		alertsWindowsPage.clickAlertsBtn();
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		alertsPage = new AlertsPage();
		Assert.assertTrue(alertsPage.isOpen(), "AlertsPage not found.");

		Log.log().info("3/8");
		alertsPage.clickSeeAlertBtn();
		Assert.assertTrue(AlertsUtil.isAlertDisplayed(), "Alert not found.");
		Assert.assertEquals(AlertsUtil.getAlertText(), TestData.getToSeeAlertMessage(), "Alert message doesn't match.");

		Log.log().info("4/8");
		AlertsUtil.acceptAlert();
		Assert.assertFalse(AlertsUtil.isAlertStillDisplayed(), "Alert still displayed.");

		Log.log().info("5/8");
		alertsPage.clickConfirmBoxBtn();
		Assert.assertTrue(AlertsUtil.isAlertDisplayed(), "Alert not found.");
		Assert.assertEquals(AlertsUtil.getAlertText(), TestData.getAlertConfirmBoxMessage(), "Alert message doesn't match.");

		Log.log().info("6/8");
		AlertsUtil.acceptAlert();
		Assert.assertFalse(AlertsUtil.isAlertStillDisplayed(), "Alert still displayed.");
		Assert.assertEquals(alertsPage.getConfirmResultText(), TestData.getAlertConfirmResultLabelText(),
				"ConfirmResultText and TestDataText not equal.");

		Log.log().info("7/8");
		alertsPage.clickPromptBoxBtn();
		Assert.assertTrue(AlertsUtil.isAlertDisplayed(), "Alert not found.");
		Assert.assertEquals(AlertsUtil.getAlertText(), TestData.getAlertPromptBoxMessage(), "Alert message doesn't match.");

		Log.log().info("8/8");
		randomStr = AlertsUtil.sendRandomStrToAlertPrompt();
		AlertsUtil.acceptAlert();
		Assert.assertFalse(AlertsUtil.isAlertStillDisplayed(), "Alert still displayed.");
		Assert.assertTrue(StringUtil.strContainsSub(alertsPage.getPromptResultText(), randomStr),
				"Randomly generated string not found in AlertPromptResultLabel.");
	}

	@Test(priority = 2)
	void frames() {
		Log.log().info("2 test case started.");
		Log.log().info("1/3");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/3");
		mainPage.clickAlertsFrameAndWindowsBtn();
		alertsWindowsPage = new AlertsWindowsPage();
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		alertsWindowsPage.clickNestedFramesBtn();
		nestedFramesPage = new NestedFramesPage();
		Assert.assertTrue(nestedFramesPage.isOpen(), "NestedFramesPage not found.");
		nestedFramesPage.switchToParentFrame();
		Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), TestData.getNestedFramesParentFrameText(),
				"Expected text and actual text not equal.");
		nestedFramesPage.switchToChildFrame();
		Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), TestData.getNestedFramesChildFrameText(),
				"Expected text and actual text not equal.");
		nestedFramesPage.switchBackFromFrames();

		Log.log().info("3/3");
		alertsWindowsPage.clickFramesBtn();
		framesPage = new FramesPage();
		Assert.assertTrue(framesPage.isOpen(), "FramesPage not found.");
		Assert.assertTrue(framesPage.isUpperFrameVisible(), "UpperFrame not found.");
		framesPage.switchToUpperFrame();
		text = framesPage.getTextFromUpperFrame();
		framesPage.switchBackFromFrames();
		Assert.assertTrue(framesPage.isLowerFrameVisible(), "LowerFrame not found.");
		framesPage.switchToLowerFrame();
		text2 = framesPage.getTextFromLowerFrame();
		framesPage.switchBackFromFrames();
		Log.log().info("UpperFrameText and LowerFrameText equal.");
		Assert.assertEquals(text, text2, "Texts not equal.");
	}

	//@Test(priority = 3)
	void webTables() {
		Log.log().info("3 test case started.");
		Log.log().info("1/5");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/5");
		mainPage.clickElementsBtn();
		elementsPage = new ElementsPage();
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		elementsPage.clickWebTablesBtn();
		webTablesPage = new WebTablesPage();
		Assert.assertTrue(webTablesPage.isOpen(), "WebTablesPage not found.");

		Log.log().info("3/5");
		webTablesPage.clickAddBtn();
		registrationForm = new RegistrationForm();
		Assert.assertTrue(registrationForm.isRegFormVisible(), "RegistrationForm not found.");

		Log.log().info("4/5");
		userNum = Integer.toString(TestData.getUserNum());
		Log.log().info("Fill the registration form with data of user #" + userNum);
		registrationForm.sendKeysFirstName(TestData.getUserFirstName());
		registrationForm.sendKeysLastName(TestData.getUserLastName());
		registrationForm.sendKeysEmail(TestData.getUserEmail());
		registrationForm.sendKeysAge(Integer.toString(TestData.getUserAge()));
		registrationForm.sendKeysSalary(Integer.toString(TestData.getUserSalary()));
		registrationForm.sendKeysDepartment(TestData.getUserDepartment());
		registrationForm.clickSubmit();
		Assert.assertFalse(registrationForm.isRegFormClosed(), "Registration form didn't close.");
		Assert.assertTrue(webTablesPage.isRecordInTable(userFirstName), "User not found in WebTable.");

		Log.log().info("5/5");
		Log.log().info("Delete user #"+userNum+" WebTable record.");
		webTablesPage.deleteRecord();
		Assert.assertTrue(webTablesPage.isRecordDeleted(userFirstName),"User data still in WebTable.");
	}

	//@Test(priority = 4)
	void handles() {
		Log.log().info("4 test case started.");
		Log.log().info("1/7");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/7");
		mainPage.clickAlertsFrameAndWindowsBtn();
		alertsWindowsPage = new AlertsWindowsPage();
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		alertsWindowsPage.clickBrowserWindowsBtn();
		browserWindowsPage = new BrowserWindowsPage();
		Assert.assertTrue(browserWindowsPage.isOpen(), "BrowserWindowsPage not found.");

		Log.log().info("3/7");
		browserWindowsPage.clickNewTabBtn();
		Assert.assertTrue(browserWindowsPage.isSubstringInCurrentUrl("/sample"), "'/sample' not found in the URL.");

		Log.log().info("4/7");
		TabsUtil.closeCurrentTab();
		Assert.assertTrue(browserWindowsPage.isBrowserWindowsPageOpen(), "BrowserWindowsPage not found.");

		Log.log().info("5/7");
		browserWindowsPage.clickElementsHeaderBtn();
		Assert.assertTrue(browserWindowsPage.isElementsDropdownShowed(), "ElementsDropdown not found.");

		browserWindowsPage.clickLinksBtn();
		linksPage = new LinksPage();
		Assert.assertTrue(linksPage.isOpen(), "LinksPage not found.");

		Log.log().info("6/7");
		linksPage.clickHomeLink();
		Assert.assertTrue(mainPage.isMainPageOpen(), "MainPage not found.");

		Log.log().info("7/7");
		TabsUtil.switchToPrevPage();
		Assert.assertTrue(linksPage.isLinksPageOpen(), "LinksPage not found.");
	}

	//@Test(priority = 5)
	void sliderProgressBar() {
		Log.log().info("5 test case started.");
		Log.log().info("1/6");

		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/6");
		mainPage.clickWidgetsBtn();
		widgetsPage = new WidgetsPage();
		Assert.assertTrue(widgetsPage.isOpen(), "WidgetsPage not found.");
		widgetsPage.clickSliderBtn();
		Assert.assertTrue(widgetsPage.isSliderFormOpen(), "SliderForm not found.");

		Log.log().info("3/6");
		widgetsPage.moveSliderToZero();
		widgetsPage.setRandomNumToSlider();
		Assert.assertTrue(widgetsPage.isSliderNumEqualToGeneratedNum(), "SliderLabelNumber not equal to the generated number.");

		Log.log().info("4/6");
		widgetsPage.clickProgressBarBtn();
		Assert.assertTrue(widgetsPage.isProgressBarFormOpen(), "ProgressBarForm not found.");

		Log.log().info("5/6");
		widgetsPage.clickStartBtn();

		Log.log().info("6/6");
		widgetsPage.clickStopBtnAt28Percent();
		Assert.assertTrue(widgetsPage.isProgressBarValueBetween28And30(), "ProgressBarValue not in[28;30].");
	}

	//@Test(priority = 6)
	void datePicker() {
		Log.log().info("6 test case started.");
		Log.log().info("1/3");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/3");
		mainPage.clickWidgetsBtn();
		widgetsPage = new WidgetsPage();
		Assert.assertTrue(widgetsPage.isOpen(), "WidgetsPage not found.");
		widgetsPage.clickDatePickerBtn();
		Assert.assertTrue(widgetsPage.isDatePickerFormOpen(), "DatePickerForm not found.");
		Assert.assertTrue(widgetsPage.isDatePickerDateActual(), "Date not actual.");
		Assert.assertTrue(widgetsPage.isDatePickerDateTimeActual(), "Date and time not actual.");

		Log.log().info("3/3");
		widgetsPage.openDateCalendar();
		Assert.assertTrue(widgetsPage.isDateCalendarOpen(), "DatePickerCalendar not found.");
		widgetsPage.pickClosest29Fev();
		Assert.assertTrue(widgetsPage.isDatePickerDate29Fev(), "DatePickerDate is not February 29.");
	}

	//@Test(priority = 7)
	void files() {
		Log.log().info("7 test case started.");
		Log.log().info("1/4");
		mainPage = new MainPage();
		mainPage.goToMainPage();
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Log.log().info("2/4");
		mainPage.clickElementsBtn();
		elementsPage = new ElementsPage();
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		elementsPage.clickUploadDownloadBtn();
		Assert.assertTrue(elementsPage.isUploadDownloadFormOpen(),
				"UploadDownloadForm not found.");

		Log.log().info("3/4");
		elementsPage.clickDownloadBtn();
		FilesUtil.isFileDownloaded();

		Log.log().info("4/4");
		elementsPage.sendFilePathToUploadInput(Constants.filePath);
		Assert.assertTrue(elementsPage.isFileNameDisplayedInUploadLabel(Constants.fileName),
				"FileName not found in UploadLabel.");
	}
}