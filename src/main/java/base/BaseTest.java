package base;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
	protected WebDriver driver;
	protected Config config;

	public BaseTest(WebDriver driver, Config config) {
		this.driver = driver;
		this.config = config;
	}

	@BeforeTest
	void beforeTestRun() {
	}

	@BeforeMethod
	void beforeTestMethod() {
	}

	@AfterTest
	void afterTestRun() {
	}

	@AfterMethod
	void afterTestMethod() {
	}

	// вызывает из Utils и сохраняет в лог
	void logInfo() {
	}
}
