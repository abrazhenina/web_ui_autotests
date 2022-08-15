package base;

import browser.Browser;
import browser.BrowserConfig;
import data.TestData;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Constants;
import utils.JsonReader;
import utils.Log;

import java.io.IOException;

public abstract class BaseTest {
	public BaseTest() {
	}

	@BeforeTest
	static public void setupTest() {
		try {
			Log.log().info("Config and test data parsing.");
			new BrowserConfig(JsonReader.readJson(Constants.getConfigPath()));
			new TestData(JsonReader.readJson(Constants.getTestDataPath()));
			Log.log().info("Browser initialization.");
			Browser.getBrowserInstance();
		} catch (IOException e) {
			Log.log().info("IOException.");
			e.printStackTrace();
		}
	}

	@BeforeMethod
	static public void setupMethod() {
		try {
			Log.log().info("Config and test data parsing.");
			new BrowserConfig(JsonReader.readJson(Constants.getConfigPath()));
			new TestData(JsonReader.readJson(Constants.getTestDataPath()));
			Log.log().info("Browser initialization.");
			Browser.getBrowserInstance();
		} catch (IOException e) {
			Log.log().info("IOException.");
			e.printStackTrace();
		}
	}

	@AfterMethod
	static public void tearDownAfterMethod() {
		Browser.getBrowserInstance().quit();
		Browser.setDriverNull();
	}
}





