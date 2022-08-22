package base;

import browser.Browser;
import browser.BrowserConfig;
import data.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Constants;
import utils.JsonReader;
import utils.Log;

public abstract class BaseTest {
	public BaseTest() {
	}

	@BeforeMethod
	static public void setupMethod() {
		Log.log().info("Config and test data parsing.");
		new BrowserConfig(JsonReader.readJson(Constants.getConfigPath()));
		new TestData(JsonReader.readJson(Constants.getTestDataPath()));
		Log.log().info("Browser initialization.");
		Browser.getBrowserInstance();
	}

	@AfterMethod
	static public void tearDownAfterMethod() {
		Log.log().info("Browser quit().");
		Browser.getBrowserInstance().quit();
		Log.log().info("Set Browser to null.");
		Browser.setDriverNull();
	}
}