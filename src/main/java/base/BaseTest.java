package base;

import browser.Browser;
import browser.BrowserConfig;
import data.TestData;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Constants;
import utils.JsonReader;

import java.io.IOException;

public abstract class BaseTest {
	final static Logger log = Logger.getLogger(BaseTest.class);
	public BaseTest() {
	}

	@BeforeTest
	static public void setup() {
		try {
			new BrowserConfig(JsonReader.readJson(Constants.getConfigPath()));
			new TestData(JsonReader.readJson(Constants.getTestDataPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	static public void tearDown() {
		Browser.getBrowserInstance().quit();
	}

	static public void log(String msg) {
		if(log.isDebugEnabled()){
			log.debug("This is debug : " + msg);
		}

		if(log.isInfoEnabled()){
			log.info("This is info : " + msg);
		}

		log.warn("This is warn : " + msg);
		log.error("This is error : " + msg);
		log.fatal("This is fatal : " + msg);
	}
}