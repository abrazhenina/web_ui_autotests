package tests;

import browser.Browser;
import browser.BrowserFactory;
import config.Config;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.JsonReader;
import org.testng.Reporter;
import utils.StringUtil;

import java.io.IOException;

public class MainPageTests {
	WebDriver driver;
	String testDataPath = "src/test/resources/testData.json";
	String configPath = "src/test/resources/config.json";
	TestData testData;
	Config config;
	String name;
	String text;
	String text2;
	MainPage mainPage;
	AlertsWindowsPage alertsWindowsPage;
	AlertsPage alertsPage;
	NestedFramesPage nestedFramesPage;
	FramesPage framesPage;
	ElementsPage elementsPage;
	WebTablesPage webTablesPage;
	RegistrationForm registrationForm;
	BrowserWindowsPage browserWindowsPage;
	LinksPage linksPage;

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
		mainPage = new MainPage();
		alertsWindowsPage = new AlertsWindowsPage();
		alertsPage = new AlertsPage();
		nestedFramesPage = new NestedFramesPage();
		framesPage = new FramesPage();
		elementsPage = new ElementsPage();
		webTablesPage = new WebTablesPage();
		registrationForm = new RegistrationForm();
		browserWindowsPage = new BrowserWindowsPage();
		linksPage = new LinksPage();
	}

	@BeforeMethod
	void beforeMethod() {
		driver = Browser.getBrowserInstance();
	}

	@AfterMethod
	void afterMethod() {
		Browser.getBrowserInstance().quit();
	}
	@AfterTest
	void tearDown() {
		Browser.getBrowserInstance().quit();
	}

	@Test(priority = 1)
	void testCase1() {
		Reporter.log("1 test case started.", true);
		Reporter.log("1/8", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Reporter.log("2/8", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click AlertsButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton(TestData.getAlertsWindowsPageAlertBtnName());
		Reporter.log("AlertsPage opens.", true);
		Assert.assertTrue(alertsPage.isOpen(), "AlertsPage not found.");

		Reporter.log("3/8", true);
		Reporter.log("Click 'Button to see alert'", true);
		alertsPage.clickButton(TestData.getToSeeAlertBtnName());
		Reporter.log("Alert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		text = TestData.getToSeeAlertMessage();
		Reporter.log("Alert message is '"+text+"'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");

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
		text = TestData.getAlertConfirmBoxMessage();
		Reporter.log("Alert message is '"+text+"'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("6/8", true);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		text = TestData.getAlertConfirmResultLabelText();
		Reporter.log("ConfirmResultLabel text '"+text+"' displayed.", true);
		Assert.assertEquals(alertsPage.getLabelText(TestData.getAlertConfirmResultLabelName()),
				TestData.getAlertConfirmResultLabelText(),
				"ConfirmResultText and TestDataText not equal.");

		Reporter.log("7/8", true);
		Reporter.log("Click 'On button click, prompt box will appear'", true);
		alertsPage.clickButton(TestData.getAlertPromptBoxBtnName());
		Reporter.log("PromptBoxAlert opens.", true);
		Assert.assertTrue(alertsPage.isAlertDisplayed(), "Alert not found.");
		text = TestData.getAlertPromptBoxMessage();
		Reporter.log("Alert message is '" + text + "'", true);
		Assert.assertEquals(text, alertsPage.getAlertText(), "Alert message doesn't match.");

		Reporter.log("8/8", true);
		Reporter.log("Send random string to PromptBoxAlert.", true);
		text = StringUtil.getRandomString();
		alertsPage.sendKeysToAlertPrompt(text);
		Reporter.log("Click OK button.", true);
		alertsPage.acceptAlert();
		Reporter.log("Alert closed.", true);
		Assert.assertFalse(alertsPage.isAlertStillDisplayed(), "Alert still displayed.");
		Reporter.log("Random string '"+text+"' displayed in the PromptLabel.", true);
		Assert.assertTrue(StringUtil.strContainsSub(alertsPage
				.getLabelText(TestData.getAlertPromptResultLabelName()), text),
				"Randomly generated string not found in AlertPromptResultLabel.");
	}

	@Test(priority = 2)
	void testCase2() {
		Reporter.log("\n2 test case started.", true);
		Reporter.log("1/3", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

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

	@Test(priority = 3)
	void testCase3() {
		Reporter.log("\n3 test case started.", true);
		Reporter.log("1/5", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Reporter.log("2/5", true);
		Reporter.log("Click ElementsButton.", true);
		mainPage.clickButton("elementsBtn");
		Reporter.log("ElementsPage opens.", true);
		Assert.assertTrue(elementsPage.isOpen(), "ElementsPage not found.");
		Reporter.log("Click WebTablesButton.", true);
		elementsPage.clickButton("webTablesBtn");
		Reporter.log("WebTablesPage opens.", true);
		Assert.assertTrue(webTablesPage.isOpen());

		Reporter.log("3/5", true);
		Reporter.log("Click AddButton.", true);
		webTablesPage.clickButton("addBtn");
		Reporter.log("RegistrationForm opens.", true);
		Assert.assertTrue(registrationForm.isRegFormVisible());

		Reporter.log("4/5", true);
		String userNum = Integer.toString(TestData.getUserNum());
		Reporter.log("Fill the registration form with data of user #"+userNum, true);
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
		Assert.assertTrue(webTablesPage.isRecordInTable(userFirstName),"User not found in WebTable.");

		Reporter.log("5/5", true);
		Reporter.log("Delete user  #"+userNum+" WebTable record.", true);
		webTablesPage.deleteRecord();
		Assert.assertTrue(webTablesPage.isRecordDeleted(userFirstName),"User data still in WebTable.");

	}

	@Test(priority = 4)
	void testCase4() {
		Reporter.log("\n4 test case started.", true);
		Reporter.log("1/7", true);
		Reporter.log("Go to MainPage.", true);
		Browser.goToUrl(config.getHomePageAddress());
		Reporter.log("MainPage opens.", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");

		Reporter.log("2/7", true);
		Reporter.log("Click AlertsFrameAndWindowsPageButton on MainPage.", true);
		mainPage.clickButton("alertsFrameAndWindowsBtn");
		Assert.assertTrue(alertsWindowsPage.isOpen(), "AlertsFrameAndWindowsPage not found.");
		Reporter.log("Click BrowserWindowsButton on AlertsWindowsPage.", true);
		alertsWindowsPage.clickButton("browserWindowsBtn");
		Reporter.log("BrowserWindowsPage opens.", true);
		Assert.assertTrue(browserWindowsPage.isOpen(), "BrowserWindowsPage not found.");

		Reporter.log("3/7", true);
		Reporter.log("Click NewTabButton.", true);
		browserWindowsPage.clickNewTabBtn();
		Reporter.log("Check the URL of new tab contains '/sample'", true);
		Assert.assertTrue(browserWindowsPage.isSubstringInCurrentUrl("/sample"));

		Reporter.log("4/7", true);
		Reporter.log("Close this tab.", true);
		browserWindowsPage.closeCurrentTab();
		Reporter.log("On the current tab is BrowserWindowsPage.", true);
		Assert.assertTrue(browserWindowsPage.isOpen(), "BrowserWindowsPage not found.");

		Reporter.log("5/7", true);
		Reporter.log("Click ElementsButton.", true);
		browserWindowsPage.clickElementsHeaderBtn();
		Assert.assertTrue(browserWindowsPage.isElementsDropdownShowed(), "ElementsDropdown not found.");
		Reporter.log("Click LinksButton.", true);
		browserWindowsPage.clickLinksBtn();
		Reporter.log("LinksPage opens.", true);
		Assert.assertTrue(linksPage.isOpen(), "LinksPage not found.");

		Reporter.log("6/7", true);
		Reporter.log("Click HomeLink.", true);
		linksPage.clickHomeLink();
		Reporter.log("New tab with MainPage opens.", true);
		Reporter.log("MainPage is open.", true);

		Reporter.log("7/7", true);
		Assert.assertTrue(mainPage.isOpen(), "MainPage not found.");
		Reporter.log("Switch to previous tab.", true);
		linksPage.switchToPrevPage();
		Reporter.log("LinksPage opens.", true);
		Assert.assertTrue(linksPage.isOpen(), "LinksPage not found.");
	}
}